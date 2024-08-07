package com.example.taskmanager.services;

import com.example.taskmanager.converters.TaskConverter;
import com.example.taskmanager.converters.UserConverter;
import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.dto.UserDto;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.exceptions.UserNotFoundException;
import com.example.taskmanager.repositories.TaskRepository;
import com.example.taskmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static UserRepository repository;
    private static TaskRepository taskRepository;

    public UserDto findById(Long id) {
        return UserConverter.toUserDto(
                repository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public List<TaskDto> findByIdAllCreated(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id))
                .getCreatedTasks().stream()
                .map(TaskConverter::toTaskDto)
                .collect(Collectors.toList());
    }

    public List<TaskDto> findByIdAllPerformed(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id))
                .getPerformedTasks().stream()
                .map(TaskConverter::toTaskDto)
                .collect(Collectors.toList());
    }

    public void addTaskToPerformedList(Long userId, Long taskId) {
        repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId))
                .getPerformedTasks()
                .add(taskRepository
                        .findById(taskId)
                        .orElseThrow(() -> new TaskNotFoundException(taskId)));
    }

    public void deleteTaskFromPerformedList(Long userId, Long taskId) {
        repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId))
                .getPerformedTasks()
                .remove(taskRepository
                        .findById(taskId)
                        .orElseThrow(() -> new TaskNotFoundException(taskId)));
    }
}
