package com.example.taskmanager.services;

import com.example.taskmanager.converters.TaskConverter;
import com.example.taskmanager.converters.UserConverter;
import com.example.taskmanager.entities.RoleEntity;
import com.example.taskmanager.entities.UserEntity;
import com.example.taskmanager.repositories.RoleRepository;
import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.responses.UserResponse;
import com.example.taskmanager.repositories.TaskRepository;
import com.example.taskmanager.repositories.UserRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    private static UserRepository repository;
    private static RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private static TaskRepository taskRepository;

    @NotNull
    @Transactional(readOnly = true)
    public UserResponse findById(@NotNull Long id) {
        return UserConverter.toUserResponse(
                repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException()));
    }

    @NotNull
    @Transactional(readOnly = true)
    public List<TaskResponse> findByIdAllCreated(@NotNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException())
                .getCreatedTasks().stream()
                .map(TaskConverter::toTaskResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Transactional(readOnly = true)
    public List<TaskResponse> findByIdAllPerformed(@NotNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException())
                .getPerformedTasks().stream()
                .map(TaskConverter::toTaskResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Transactional
    public void addTaskToPerformedList(@NotNull Long userId, @NotNull Long taskId) {
        repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException())
                .getPerformedTasks()
                .add(taskRepository
                        .findById(taskId)
                        .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Transactional
    public void deleteTaskFromPerformedList(@NotNull Long userId, @NotNull Long taskId) {
        repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException())
                .getPerformedTasks()
                .remove(taskRepository
                        .findById(taskId)
                        .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = repository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Transactional
    public boolean saveUser(UserEntity user) {
        UserEntity userFromDB = repository.findByEmail(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new RoleEntity(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
        return true;
    }
}
