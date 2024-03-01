package com.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.taskmanager.entities.TaskEntity;
import com.taskmanager.repositories.TaskRepository;

@Service
public class TaskService {
  @Autowired
  private TaskRepository taskRepository;
  public TaskEntity createTask(TaskEntity task) {
    return taskRepository.save(TaskEntity.builder()
        .title(task.getTitle())
        .description(task.getDescription())
        .dueDate(task.getDueDate())
        .priority(task.getPriority())
        .status(task.getStatus()).build());
  }

  public List<TaskEntity> getAllTasks() {
    return taskRepository.findAll();
  }

  public TaskEntity getTaskById(Long taskId) {
    return taskRepository.findById(taskId).orElse(null);
  }

  public TaskEntity updateTask(TaskEntity task) {
    return taskRepository.save(task);
  }

  public void deleteTask(Long taskId) {
    taskRepository.deleteById(taskId);
  }

  public void deleteAllTasks() {
    taskRepository.deleteAll();
  }
}