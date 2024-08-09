package com.example.taskmanager.responses;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

@Hidden
@Schema(description = "Сущность произошедшей ошибки")

public class ExceptionResponse {
    @Schema(description = "Сообщение об ошибке")

    private final String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
