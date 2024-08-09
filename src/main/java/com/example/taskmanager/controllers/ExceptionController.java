package com.example.taskmanager.controllers;

import com.example.taskmanager.responses.ExceptionResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
@RestControllerAdvice
@Hidden
@Tag(name="Возникновение ошибки", description = "В ходе работы сервиса что-то пошло не так")
public class ExceptionController {

    @Operation(
            summary = "Сущность не найдена"
    )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    private ExceptionResponse notFound(EntityNotFoundException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @Operation(
            summary = "Введены некорректные данные"
    )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalAccessException.class)
    private ExceptionResponse illegalAccess(IllegalAccessException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @Operation(
            summary = "Непредвиденная ошибка в ходе работы"
    )
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    private ExceptionResponse error(RuntimeException ex) {
        return new ExceptionResponse(ex.getMessage());
    }
}
