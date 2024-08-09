package com.example.taskmanager.services;

import com.example.taskmanager.entities.TaskEntity;
import com.example.taskmanager.entities.UserEntity;
import com.example.taskmanager.entities.enums.Priority;
import com.example.taskmanager.entities.enums.Status;
import com.example.taskmanager.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {
    private static TaskRepository repository;

    @Test
    void findById() {
        Optional<TaskEntity> optTestTask = repository.findById(Long.MAX_VALUE);
        assertNull(optTestTask);

        UserEntity testUser = new UserEntity();
        testUser.setId(Long.MAX_VALUE);
        testUser.setFirstName("name");
        testUser.setLastName("surname");

        TaskEntity testTask = new TaskEntity();
        testTask.setId(Long.MAX_VALUE);
        testTask.setHeader("test");
        testTask.setDescription("test");
        testTask.setStatus(Status.WAITING);
        testTask.setPriority(Priority.MEDIUM);
        testTask.setAuthor(testUser);

        repository.save(testTask);
        optTestTask = repository.findById(Long.MAX_VALUE);
        assertNotNull(optTestTask);

        repository.deleteById(Long.MAX_VALUE);
    }

    @Test
    void create() {
        UserEntity testUser = new UserEntity();
        testUser.setId(Long.MAX_VALUE);
        testUser.setFirstName("name");
        testUser.setLastName("surname");

        TaskEntity testTask = new TaskEntity();
        testTask.setId(Long.MAX_VALUE);
        testTask.setHeader("test");
        testTask.setDescription("test");
        testTask.setStatus(Status.WAITING);
        testTask.setPriority(Priority.MEDIUM);
        testTask.setAuthor(testUser);

        repository.save(testTask);
        Boolean isSaved = repository.existsById(Long.MAX_VALUE);

        assertTrue(isSaved);

        repository.deleteById(Long.MAX_VALUE);

        testTask.setHeader("");
        testTask.setDescription("");

        repository.save(testTask);
        isSaved = repository.existsById(Long.MAX_VALUE);
        assertFalse(isSaved);

        repository.deleteById(Long.MAX_VALUE);
    }
}