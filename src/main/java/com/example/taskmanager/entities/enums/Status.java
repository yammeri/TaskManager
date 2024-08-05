package com.example.taskmanager.entities.enums;

public enum Status {
    WAITING("Task is waiting"),
    PROGRESS("Task in progress"),
    COMPLETED("Task completed");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status fromString(String value) throws IllegalAccessException {
        if (value != null) {
            for (Status status : Status.values()) {
                if (value.equalsIgnoreCase(status.value)) {
                    return status;
                }
            }
        }
       throw new IllegalAccessException("No such value");
    }
}
