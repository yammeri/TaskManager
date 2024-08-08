package com.example.taskmanager.converters;

import com.example.taskmanager.responses.CommentResponse;
import com.example.taskmanager.entities.CommentEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentConverter {
    public static CommentResponse toCommentResponse(CommentEntity entity) {
        CommentResponse dto = new CommentResponse();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setText(entity.getText());
        return dto;
    }

    public static CommentEntity toCommentEntity(CommentResponse dto) {
        CommentEntity entity = new CommentEntity();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setText(dto.getText());
        return entity;
    }
}
