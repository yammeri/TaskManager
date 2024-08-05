package com.example.taskmanager.exceptions;

public class PriorityIllegalArgumentException extends IllegalArgumentException {
    public PriorityIllegalArgumentException(String value) {
        super("No such priority value " + value);
    }
}
