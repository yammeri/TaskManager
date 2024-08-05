package com.example.taskmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StatusIllegalArgumentAdvice {
    @ExceptionHandler(StatusIllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String statusIllegalArgumentHandler(StatusIllegalArgumentException e) {
        return e.getMessage();
    }
}
