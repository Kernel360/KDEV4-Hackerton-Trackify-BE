package com.example.trackify.task.domain;

import com.example.trackify.category.domain.Category;
import com.example.trackify.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_sequence")
    private BigInteger taskSequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_start_date")
    private LocalDate taskStartDate;

    @Column(name = "task_end_date")
    private LocalDate taskEndDate;

    @Column(name = "task_status")
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus taskStatus;
}
