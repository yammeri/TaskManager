package com.example.taskmanager.controllers;

import com.example.taskmanager.entities.User;
import com.example.taskmanager.exceptions.UserNotFoundException;
import com.example.taskmanager.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
    /* TODO:
    *   1. GET /users/{id}/createdTasks
    *   2. GET /users/{id}/performedTasks
    *   3. Подумать над названиями
    *   4. Написать назначение пользователя исполнителем задачи */
}
