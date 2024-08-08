package com.example.taskmanager.services;

import com.example.taskmanager.converters.TaskConverter;
import com.example.taskmanager.converters.UserConverter;
import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.responses.UserResponse;
import com.example.taskmanager.repositories.TaskRepository;
import com.example.taskmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    private static UserRepository repository;
    private static TaskRepository taskRepository;

    public UserResponse findById(Long id) {
        return UserConverter.toUserResponse(
                repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException()));
    }

    public List<TaskResponse> findByIdAllCreated(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException())
                .getCreatedTasks().stream()
                .map(TaskConverter::toTaskResponse)
                .collect(Collectors.toList());
    }

    public List<TaskResponse> findByIdAllPerformed(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException())
                .getPerformedTasks().stream()
                .map(TaskConverter::toTaskResponse)
                .collect(Collectors.toList());
    }

    public void addTaskToPerformedList(Long userId, Long taskId) {
        repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException())
                .getPerformedTasks()
                .add(taskRepository
                        .findById(taskId)
                        .orElseThrow(() -> new EntityNotFoundException()));
    }

    public void deleteTaskFromPerformedList(Long userId, Long taskId) {
        repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException())
                .getPerformedTasks()
                .remove(taskRepository
                        .findById(taskId)
                        .orElseThrow(() -> new EntityNotFoundException()));
    }
}
