package com.example.trackify.todo.domain;

import com.example.trackify.category.domain.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoSequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "category_sequence")  // FK 설정
    private Category category;

    private LocalDate todoDate;
    private String todoWork;

    @Enumerated(EnumType.ORDINAL)
    private TodoStatus todoCheck;
}
