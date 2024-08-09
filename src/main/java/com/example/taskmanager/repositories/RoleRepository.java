package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserEntity, Long> {
}
