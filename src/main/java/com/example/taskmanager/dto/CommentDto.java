package com.example.taskmanager.dto;

import java.util.Date;

public class CommentDto {
    private Long id;
    private Date date;
    private String text;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }
}
