package com.example.taskmanager.responses;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Сущность комментария")
public class CommentResponse {
    @Schema(description = "Идентификатор")
    private Long id;
    @Schema(description = "Дата создания")
    private LocalDate date;
    @Schema(description = "Текст")

    private String text;

    public Long getId() {
        return this.id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getText() {
        return this.text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }
}
