package com.example.taskmanager.responses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность пользователя")
public class UserResponse {
    @Schema(description = "Идентификатор")
    private Long id;
    @Schema(description = "Имя")
    private String firstName;
    @Schema(description = "Фамилия")
    private String lastName;

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
