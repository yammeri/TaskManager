package com.example.taskmanager.controllers;

import com.example.taskmanager.entities.UserEntity;
import com.example.taskmanager.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Tag(name="Регистрация", description = "Создание новых пользователей")
public class RegistrationController {
    private UserService userService;

    @Operation(
            summary = "Регистрация пользователя"
    )
    @PostMapping(value = "/registration", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String addUser(@ModelAttribute("userForm") @Validated UserEntity userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }
}
