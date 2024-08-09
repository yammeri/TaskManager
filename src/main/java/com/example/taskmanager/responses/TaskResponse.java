package com.example.taskmanager.responses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность задачи")

public class TaskResponse {
    @Schema(description = "Идентификатор")

    private Long id;
    @Schema(description = "Заголовок")
    private String header;
    @Schema(description = "Описание")
    private String description;
    @Schema(description = "Статус", enumAsRef = true)
    private String status;
    @Schema(description = "Приоритет", enumAsRef = true)
    private String priority;
    @Schema(description = "Идентификатор автора")
    private Long authorId;
    @Schema(description = "Идентификатор исполнителя")
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
