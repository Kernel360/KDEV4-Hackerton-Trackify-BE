package com.example.trackify.task.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaskEntity {
    @Id @GeneratedValue
    @Column(name = "task_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "task_title")
    private String title;

    @Column(name = "task_start_date")
    private LocalDate startDate;

    @Column(name = "task_end_date")
    private LocalDate endDate;

    @Column(name = "task_status")
    private Integer status;

    //==Task 생성 메서드==//
    public static TaskEntity createTask(String title, LocalDate start_date, LocalDate end_date) {
        TaskEntity task = new TaskEntity();

        task.setTitle(title);
        task.setStartDate(start_date);
        task.setEndDate(end_date);

        return task;
    }
}
