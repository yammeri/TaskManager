package com.example.taskmanager.services;

import com.example.taskmanager.entities.UserEntity;
import com.example.taskmanager.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    private static UserRepository repository;

    @Test
    void findById() {
        Optional<UserEntity> optTestUser = repository.findById(Long.MAX_VALUE);
        assertNull(optTestUser);

        UserEntity testUser = new UserEntity();
        testUser.setId(Long.MAX_VALUE);
        testUser.setFirstName("name");
        testUser.setLastName("surname");

        repository.save(testUser);
        optTestUser = repository.findById(Long.MAX_VALUE);
        assertNotNull(optTestUser);

        repository.deleteById(Long.MAX_VALUE);
    }
}