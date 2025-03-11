package com.example.trackify.category.domain;

import com.example.trackify.task.domain.Task;
import com.example.trackify.todo.domain.Todo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categorySequence;

    private String categoryName;
    private Integer categoryGoalTime;
    private Integer categoryRecordTime;

    @Enumerated(EnumType.ORDINAL)
    private CategoryStatus categoryStatus;

    @ManyToOne
    @JoinColumn(name = "task_sequence", nullable = false)
    private Task task;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos = new ArrayList<>();
}
