package com.project.todo.task;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
    	this.taskService = taskService;
    }
}
