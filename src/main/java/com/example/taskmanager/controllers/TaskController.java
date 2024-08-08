package com.example.taskmanager.controllers;

import com.example.taskmanager.responses.CommentResponse;
import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.services.TaskService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // создаём задачу
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskResponse create(@RequestBody TaskResponse response) {
        return taskService.create(response);
    }

    // обновляем название и/или описание задачи по id
    @PatchMapping(value = "/{taskId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskResponse update(@PathVariable Long taskId, @RequestBody TaskResponse response) {
        return taskService.update(taskId, response);
    }

    // получаем пользователя по id
    @GetMapping(value = "/{taskId}", produces = APPLICATION_JSON_VALUE)
    public TaskResponse findById(@PathVariable Long taskId) {
        return taskService.findById(taskId);
    }

    // меняем статус выполнения задачи на "В процессе"
    @PatchMapping(value = "/{taskId}/progress", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToInProgress(@PathVariable Long taskId) {
        return taskService.updateStatus(taskId, "In progress");
    }

    // меняем статус выполнения задачи на "Завершено"
    @PatchMapping(value = "/{taskId}/completed", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToCompleted(@PathVariable Long taskId) {
        return taskService.updateStatus(taskId, "Completed");
    }

    // меняем приоритет выполнения задачи на "Низкий"
    @PatchMapping(value = "/{taskId}/low", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToLowPriority(@PathVariable Long taskId) {
        return taskService.updatePriority(taskId, "Low");
    }

    // меняем приоритет выполнения задачи на "Средний"
    @PatchMapping(value = "/{taskId}/medium", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToMediumPriority(@PathVariable Long taskId) {
        return taskService.updatePriority(taskId, "Medium");
    }

    // меняем приоритет выполнения задачи на "Высокий"
    @PatchMapping(value = "/{taskId}/high", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToHighPriority(@PathVariable Long taskId) {
        return taskService.updatePriority(taskId, "High");
    }

    // получаем список всех комментариев к задаче
    @GetMapping(value = "/{taskId}/comments", produces = APPLICATION_JSON_VALUE)
    public List<CommentResponse> findByIdAllComments(@PathVariable Long taskId) {
        return taskService.findByIdAllComments(taskId);
    }

    // изменяем исполнителя задачи
    @PatchMapping(value = "/{taskId}/performer/{performerId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskResponse setPerformerById(@PathVariable Long taskId, @PathVariable Long performerId) {
        return taskService.setPerformer(taskId, performerId);
    }

}
