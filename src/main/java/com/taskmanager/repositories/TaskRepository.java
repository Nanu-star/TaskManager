package com.taskmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}