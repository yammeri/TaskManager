package com.example.taskmanager.controllers;

import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }
}
