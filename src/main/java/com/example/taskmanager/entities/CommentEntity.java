package com.example.taskmanager.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "text", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommentEntity)) {
            return false;
        }
        CommentEntity comment = (CommentEntity) o;
        return Objects.equals(this.id, comment.id) &&
                Objects.equals(this.date, comment.date) &&
                Objects.equals(this.text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.date, this.text);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + this.id +
                ", date=" + this.date.toString() +
                ", text='" + text + '\'' +
                '}';
    }
}
