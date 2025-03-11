package com.example.trackify.task.controller;

import com.example.trackify.task.domain.TaskForm;
import com.example.trackify.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "")
    public TaskForm createTask(

    ){

    }

    @GetMapping(path = "")
    public List<TaskForm> findAllTasks(

    ){

    }

    @GetMapping(path = /{task_sequence})

}
