package com.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.entities.TaskEntity;
import com.taskmanager.service.TaskService;
@RequestMapping("/api/v1/task-manager")
@RestController
public class TaskController {
  @Autowired
  private TaskService taskService;

  // Create a new task
  @CrossOrigin
  @PostMapping
  public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity task) {
    return ResponseEntity.status(201).body(taskService.createTask(task));
  }

  // Get all tasks
  @CrossOrigin
  @GetMapping
  public ResponseEntity<List<TaskEntity>> getAllTasks() {
    List<TaskEntity> tasks = taskService.getAllTasks();
    return ResponseEntity.ok(tasks);
  }

  // Get a task by ID
  @CrossOrigin
  @GetMapping(value = "/{taskId}",
      produces = {"application/json"}
  )
  public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long taskId) {
    TaskEntity task = taskService.getTaskById(taskId);
    if (task == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(task);
  }

  // Update a task
  @CrossOrigin
  @PutMapping(value = "tasks/{taskId}",
      consumes = {"application/json"},
      produces = {"application/json"})
  public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity task) {
    TaskEntity updatedTask = taskService.updateTask(task);
    if (updatedTask == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updatedTask);
  }

  // Delete a task
  @CrossOrigin
  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
    taskService.deleteTask(taskId);
    return ResponseEntity.noContent().build();
  }
  @CrossOrigin
  @DeleteMapping()
  public ResponseEntity<Void> deleteAllTasks() {
    taskService.deleteAllTasks();
    return ResponseEntity.noContent().build();
  }
}