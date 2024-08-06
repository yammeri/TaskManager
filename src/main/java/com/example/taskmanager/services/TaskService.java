package com.example.taskmanager.services;

import com.example.taskmanager.converters.CommentConverter;
import com.example.taskmanager.converters.TaskConverter;
import com.example.taskmanager.dto.CommentDto;
import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.entities.TaskEntity;
import com.example.taskmanager.entities.enums.Priority;
import com.example.taskmanager.entities.enums.Status;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void createTask(TaskDto dto) {
        repository.save(TaskConverter.toTaskEntity(dto));
    }

    public void updateTask(Long id, String header, String description) {
        TaskEntity task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        repository.deleteById(id);

        task.setHeader(header);
        task.setDescription(description);
        repository.save(task);
    }

    public void updateHeader(Long id, String header) {
        TaskEntity task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        repository.deleteById(id);

        task.setHeader(header);
        repository.save(task);
    }

    public void updateDescription(Long id, String description) {
        TaskEntity task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        repository.deleteById(id);

        task.setDescription(description);
        repository.save(task);
    }

    public TaskDto findById(Long id) {
        return TaskConverter.toTaskDto(
                repository.findById(id)
                        .orElseThrow(() -> new TaskNotFoundException(id)));
    }

    public void updatePriority(Long id, String priority) {
        TaskEntity task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        repository.deleteById(id);
        task.setPriority(Priority.fromString(priority));
        repository.save(task);
    }

    public void updateStatus(Long id, String status) {
        TaskEntity task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        repository.deleteById(id);
        task.setStatus(Status.fromString(status));
        repository.save(task);
    }

    public List<CommentDto> findByIdAllComments(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id))
                .getAllComments().stream()
                .map(CommentConverter::toCommentDto)
                .collect(Collectors.toList());
    }
}
