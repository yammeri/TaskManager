package com.example.taskmanager.converters;

import com.example.taskmanager.responses.UserResponse;
import com.example.taskmanager.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public static UserResponse toUserResponse(UserEntity entity) {
        UserResponse dto = new UserResponse();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    public static UserEntity toUserEntity(UserResponse dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}
