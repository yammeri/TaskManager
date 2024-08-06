package com.example.taskmanager.dto;

public class TaskDto {
    private Long id;
    private String header;
    private String description;
    private String status;
    private String priority;

    public Long getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
