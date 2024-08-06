package com.example.taskmanager.services;

import com.example.taskmanager.converters.TaskConverter;
import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.exceptions.UserNotFoundException;
import com.example.taskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
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
}
