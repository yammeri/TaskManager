package com.example.taskmanager.converters;

import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.entities.TaskEntity;
import com.example.taskmanager.entities.enums.Priority;
import com.example.taskmanager.entities.enums.Status;
import org.springframework.stereotype.Service;

@Service
public class TaskConverter {
    public static TaskDto toTaskDto(TaskEntity entity) {
        TaskDto dto = new TaskDto();
        dto.setId(entity.getId());
        dto.setHeader(entity.getHeader());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus().getValue());
        dto.setPriority(entity.getPriority().getValue());
        return dto;
    }

    public static TaskEntity toTaskEntity(TaskDto dto) {
        TaskEntity entity = new TaskEntity();
        entity.setId(dto.getId());
        entity.setHeader(dto.getHeader());
        entity.setDescription(dto.getDescription());
        entity.setStatus(Status.fromString(dto.getStatus()));
        entity.setPriority(Priority.fromString(dto.getPriority()));
        return entity;
    }
}
