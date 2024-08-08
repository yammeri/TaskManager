package com.example.taskmanager.responses;

import java.time.LocalDate;

public class CommentResponse {
    private Long id;
    private LocalDate date;
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
