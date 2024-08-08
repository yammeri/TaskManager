package com.example.taskmanager.services;

import com.example.taskmanager.converters.CommentConverter;
import com.example.taskmanager.converters.TaskConverter;
import com.example.taskmanager.converters.UserConverter;
import com.example.taskmanager.responses.CommentResponse;
import com.example.taskmanager.responses.TaskResponse;
import com.example.taskmanager.entities.TaskEntity;
import com.example.taskmanager.entities.UserEntity;
import com.example.taskmanager.entities.enums.Priority;
import com.example.taskmanager.entities.enums.Status;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;

import static java.util.Optional.ofNullable;

@Service
public class TaskService {
    private static TaskRepository repository;

    public TaskResponse create(TaskResponse dto) {
        return TaskConverter.toTaskResponse(repository.save(TaskConverter.toTaskEntity(dto)));
    }

    public TaskResponse update(Long id, TaskResponse response) {
        TaskEntity task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        taskUpdate(task, response);
        return TaskConverter.toTaskResponse(repository.save(task));
    }

    private void taskUpdate(TaskEntity task, TaskResponse response) {
        ofNullable(response.getHeader()).ifPresent(task::setHeader);
        ofNullable(response.getDescription()).ifPresent(task::setDescription);
    }

    public TaskResponse findById(Long id) {
        return TaskConverter.toTaskResponse(
                repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException()));
    }

    public TaskResponse updatePriority(Long id, String priority) {
        TaskEntity task = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        task.setPriority(Priority.fromString(priority));
        repository.save(task);
        return null;
    }

    public TaskResponse updateStatus(Long id, String status) {
        TaskEntity task = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        task.setStatus(Status.fromString(status));
        repository.save(task);
        return null;
    }

    public List<CommentResponse> findByIdAllComments(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException())
                .getAllComments().stream()
                .map(CommentConverter::toCommentResponse)
                .collect(Collectors.toList());
    }

    public TaskResponse setPerformer(Long taskId, Long performerId) {
        TaskEntity task = repository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException());

        UserEntity lastPerformer = task.getPerformer();

        UserService userService = new UserService();

        if (lastPerformer.getId() != performerId) {
            if (lastPerformer != null) {
                userService.deleteTaskFromPerformedList(lastPerformer.getId(), taskId);
            }
            userService.addTaskToPerformedList(performerId, taskId);
            task.setPerformer(UserConverter
                    .toUserEntity(userService.findById(performerId)));
        }

        return TaskConverter.toTaskResponse(task);
    }
}
