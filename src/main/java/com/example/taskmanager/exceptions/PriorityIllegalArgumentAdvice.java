package com.example.taskmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PriorityIllegalArgumentAdvice {
    @ExceptionHandler(PriorityIllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String priorityIllegalArgumentHandler(PriorityIllegalArgumentException e) {
        return e.getMessage();
    }
}
