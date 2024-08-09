package com.example.taskmanager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "TaskManager Swagger",
                version = "0.0.1",
                contact = @Contact(
                        name = "Зязина Арина",
                        email = "Arina.Zyazina@yandex.ru"
                )
        )
)
public class OpenApiConfig {
}
