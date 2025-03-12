package com.example.trackify.task.domain;

import com.example.trackify.category.domain.Category;
import com.example.trackify.user.domain.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_sequence")
    private Long taskSequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @Builder.Default
    @JsonManagedReference
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
