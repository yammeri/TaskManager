package com.example.taskmanager.entities.enums;

public enum Priority {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private String value;

    private Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Priority fromString(String value) {
        if (value != null) {
            for (Priority priority: Priority.values()) {
                if (value.equalsIgnoreCase(priority.value)) {
                    return priority;
                }
            }
        }
        throw new IllegalArgumentException(value);
    }
}
