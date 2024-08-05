package com.example.taskmanager.entities;

import com.example.taskmanager.entities.enums.Priority;
import com.example.taskmanager.entities.enums.Status;

import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "header", nullable = false)
    private String header;
    @Column(name = "description")
    private String description;
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "priority", nullable = false)
    private Priority priority;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private HashSet<Comment> allComments = new HashSet<Comment>();

    public Long getId() {
        return this.id;
    }

    public String getHeader() {
        return this.header;
    }

    public String getDescription() {
        return this.description;
    }

    public Status getStatus() {
        return this.status;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public HashSet<Comment> getAllComments() {
        return this.allComments;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setAllComments(HashSet<Comment> allComments) {
        this.allComments = allComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(this.id, task.id) &&
                Objects.equals(this.header, task.header) &&
                Objects.equals(this.description, task.description) &&
                this.status.equals(task.status) &&
                this.priority.equals(task.priority) &&
                Objects.equals(allComments, task.allComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.header, this.description, this.status, this.priority, this.allComments);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + this.id +
                ", header='" + this.header + '\'' +
                ", description='" + this.description + '\'' +
                ", status=" + this.status +
                ", priority=" + this.priority +
                ", allComments=" + this.allComments +
                '}';
    }
}
