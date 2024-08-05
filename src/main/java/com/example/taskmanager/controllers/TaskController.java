package com.example.taskmanager.controllers;

import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    /* TODO:
    *   1. Написать все "базовые" действия с задачами
    *   2. GET /tasks/{id}/comments
    *   3. Написать запросы для изменения статуса выполнения задания
    *   4. Написать запросы для изменения приоритета выполнения задания */
}
