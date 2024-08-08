package com.example.taskmanager.controllers;

import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/users")
public class UsersListController {
    private UserService userService;

    public UsersListController(UserService userService) {
        this.userService = userService;
    }

    // получаем список созданных пользователем задач
    @GetMapping(value = "/{userId}/created", produces = APPLICATION_JSON_VALUE)
    public List<TaskResponse> findByIdCreated(@PathVariable Long userId) {
        return userService.findByIdAllCreated(userId);
    }

    // получаем список исполняемых пользователем задач
    @GetMapping(value = "/{userId}/performed", produces = APPLICATION_JSON_VALUE)
    public List<TaskResponse> findByIdPerformed(@PathVariable Long userId) {
        return userService.findByIdAllPerformed(userId);
    }
}
