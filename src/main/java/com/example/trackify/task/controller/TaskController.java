package com.example.trackify.task.controller;

import com.example.trackify.task.domain.TaskEntity;
import com.example.trackify.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "")
    public TaskEntity createTask(

    ){

    }

}
