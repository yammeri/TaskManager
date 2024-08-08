package com.example.taskmanager.responses;

public class TaskResponse {
    private Long id;
    private String header;
    private String description;
    private String status;
    private String priority;
    private Long authorId;
    private Long performerId;

    public Long getId() {
        return this.id;
    }

    public String getHeader() {
        return this.header;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPriority() {
        return this.priority;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public Long getPerformerId() {
        return this.performerId;
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

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setPerformerId(Long performerId) {
        this.performerId = performerId;
    }
}
