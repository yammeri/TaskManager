package com.example.taskmanager.entities.enums;

public enum Status {
    WAITING("Is waiting"),
    PROGRESS("In progress"),
    COMPLETED("Completed");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status fromString(String value) {
        if (value != null) {
            for (Status status : Status.values()) {
                if (value.equalsIgnoreCase(status.value)) {
                    return status;
                }
            }
        }
       throw new IllegalArgumentException(value);
    }
}
