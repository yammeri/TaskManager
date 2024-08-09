package com.example.taskmanager.controllers;

import com.example.taskmanager.responses.CommentResponse;
import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="Задачи", description = "Взаимодействие с задачами")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
            summary = "Метод добавления новой задачи"
    )
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskResponse create(@RequestBody TaskResponse response) {
        return taskService.create(response);
    }

    @Operation(
            summary = "Метод обновления основной информации о задаче"
    )
    @PatchMapping(value = "/{taskId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskResponse update(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId, @RequestBody  TaskResponse response) {
        return taskService.update(taskId, response);
    }

    @Operation(
            summary = "Метод получения информации о задаче"
    )
    @GetMapping(value = "/{taskId}", produces = APPLICATION_JSON_VALUE)
    public TaskResponse findById(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId) {
        return taskService.findById(taskId);
    }

    @Operation(
            summary = "Метод изменения статуса задачи на \"В процессе\""
    )
    @PatchMapping(value = "/{taskId}/progress", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToInProgress(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId) {
        return taskService.updateStatus(taskId, "In progress");
    }

    @Operation(
            summary = "Метод изменения статуса задачи на \"Завершено\""
    )
    @PatchMapping(value = "/{taskId}/completed", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToCompleted(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId) {
        return taskService.updateStatus(taskId, "Completed");
    }

    @Operation(
            summary = "Метод изменения приоритета задачи на \"Низкий\""
    )
    @PatchMapping(value = "/{taskId}/low", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToLowPriority(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId) {
        return taskService.updatePriority(taskId, "Low");
    }

    @Operation(
            summary = "Метод изменения приоритета задачи на \"Средний\""
    )
    @PatchMapping(value = "/{taskId}/medium", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToMediumPriority(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId) {
        return taskService.updatePriority(taskId, "Medium");
    }

    @Operation(
            summary = "Метод изменения приоритета задачи на \"Высокий\""
    )
    @PatchMapping(value = "/{taskId}/high", produces = APPLICATION_JSON_VALUE)
    public TaskResponse updateToHighPriority(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId) {
        return taskService.updatePriority(taskId, "High");
    }

    @Operation(
            summary = "Метод получения списка всех коммантариев к задаче"
    )
    @GetMapping(value = "/{taskId}/comments", produces = APPLICATION_JSON_VALUE)
    public List<CommentResponse> findByIdAllComments(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId) {
        return taskService.findByIdAllComments(taskId);
    }

    @Operation(
            summary = "Метод обновления информации об исполнителе задачи"
    )
    @PatchMapping(value = "/{taskId}/performer/{performerId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskResponse setPerformerById(@PathVariable @Parameter(description = "Идентификатор задачи") Long taskId, @PathVariable @Parameter(description = "Идентификатор пользователя") Long performerId) {
        return taskService.setPerformer(taskId, performerId);
    }

}
