package com.example.taskmanager.services;

import com.example.taskmanager.converters.TaskConverter;
import com.example.taskmanager.converters.UserConverter;
import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.responses.UserResponse;
import com.example.taskmanager.repositories.TaskRepository;
import com.example.taskmanager.repositories.UserRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private static UserRepository repository;
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
}
