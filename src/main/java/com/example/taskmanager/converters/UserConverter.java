package com.example.taskmanager.converters;

import com.example.taskmanager.dto.UserDto;
import com.example.taskmanager.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public static UserDto toUserDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    public static UserEntity toUserEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}
