package com.example.trackify.task.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id @GeneratedValue
    @Column(name = "task_sequence")
    private BigInteger TaskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "task_title")
    private String TaskTitle;

    @Column(name = "task_start_date")
    private LocalDate TaskStartDate;

    @Column(name = "task_end_date")
    private LocalDate TaskEndDate;

    @Column(name = "task_status")
    private Integer TaskStatus;

    //==Task 생성 메서드==//
    public static Task createTask(String title, LocalDate start_date, LocalDate end_date) {
        Task task = new Task();

        task.setTaskTitle(title);
        task.setTaskStartDate(start_date);
        task.setTaskEndDate(end_date);

        return task;
    }
}
