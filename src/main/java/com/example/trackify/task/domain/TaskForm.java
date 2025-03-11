package com.example.trackify.task.domain;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class TaskForm {
    private String taskTitle;
    private LocalDate taskStartDate;
    private LocalDate taskEndDate;
}
