package com.example.taskmanager.exceptions;

public class StatusIllegalArgumentException extends IllegalArgumentException {
    public StatusIllegalArgumentException(String value) {
        super("No such status value " + value);
    }
}
