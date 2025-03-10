package com.example.trackify.task.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class TaskForm {
    private int sequence;

    private String title;
    private LocalDate startDate;
    private LocalDate endDate;

    //추후 카테고리 추가

    private int status;
}
