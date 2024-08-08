package com.example.taskmanager.converters;

import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.entities.TaskEntity;
import com.example.taskmanager.entities.enums.Priority;
import com.example.taskmanager.entities.enums.Status;
import com.example.taskmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskConverter {
    private static UserRepository repository;
    public static TaskResponse toTaskResponse(TaskEntity entity) {
        TaskResponse dto = new TaskResponse();
        dto.setId(entity.getId());
        dto.setHeader(entity.getHeader());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus().getValue());
        dto.setPriority(entity.getPriority().getValue());
        dto.setAuthorId(entity.getAuthor().getId());
        dto.setPerformerId(entity.getPerformer().getId());
        return dto;
    }

    public static TaskEntity toTaskEntity(TaskResponse dto) {
        TaskEntity entity = new TaskEntity();
        entity.setId(dto.getId());
        entity.setHeader(dto.getHeader());
        entity.setDescription(dto.getDescription());
        entity.setStatus(Status.fromString(dto.getStatus()));
        entity.setPriority(Priority.fromString(dto.getPriority()));
        entity.setAuthor(repository.findById(dto.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException()));
        entity.setPerformer(repository.findById(dto.getPerformerId())
                .orElseThrow(() -> new EntityNotFoundException()));
        return entity;
    }
}
