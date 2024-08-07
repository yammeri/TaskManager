package com.example.taskmanager.dto;

import java.util.Date;

public class CommentDto {
    private Long id;
    private Date date;
    private String text;

    public Long getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public String getText() {
        return this.text;
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
