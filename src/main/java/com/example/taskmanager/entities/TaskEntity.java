package com.example.taskmanager.entities;

import com.example.taskmanager.entities.enums.Priority;
import com.example.taskmanager.entities.enums.Status;

import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class TaskEntity {
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
    private HashSet<CommentEntity> allComments = new HashSet<CommentEntity>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performer_id")
    private UserEntity performer;

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

    public HashSet<CommentEntity> getAllComments() {
        return this.allComments;
    }

    public UserEntity getAuthor() {
        return this.author;
    }

    public UserEntity getPerformer() {
        return this.performer;
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

    public void setAllComments(HashSet<CommentEntity> allComments) {
        this.allComments = allComments;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public void setPerformer(UserEntity performer) {
        this.performer = performer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskEntity)) {
            return false;
        }
        TaskEntity task = (TaskEntity) o;
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
