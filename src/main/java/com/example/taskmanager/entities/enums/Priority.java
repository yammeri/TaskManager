package com.example.taskmanager.entities.enums;

public enum Priority {
    HIGH("High priority"),
    MEDIUM("Medium priority"),
    LOW("Low priority");

    private String value;

    private Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Priority fromString(String value) throws IllegalAccessException {
        if (value != null) {
            for (Priority priority: Priority.values()) {
                if (value.equalsIgnoreCase(priority.value)) {
                    return priority;
                }
            }
        }
        throw new IllegalAccessException("No such value"); // ?
    }
}
