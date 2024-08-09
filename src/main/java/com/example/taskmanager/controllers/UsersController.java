package com.example.taskmanager.controllers;

import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name="Пользователи", description = "Взаимодействие с пользователями")
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Метод получения списка созданных пользователем задач"
    )
    @GetMapping(value = "/{userId}/created", produces = APPLICATION_JSON_VALUE)
    public List<TaskResponse> findByIdCreated(@PathVariable @Parameter(description = "Идентификатор пользователя") Long userId) {
        return userService.findByIdAllCreated(userId);
    }

    @Operation(
            summary = "Метод получения списка исполняемых пользователем задач"
    )
    @GetMapping(value = "/{userId}/performed", produces = APPLICATION_JSON_VALUE)
    public List<TaskResponse> findByIdPerformed(@PathVariable @Parameter(description = "Идентификатор пользователя") Long userId) {
        return userService.findByIdAllPerformed(userId);
    }
}
