package com.project.todo.task;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }
    
}
