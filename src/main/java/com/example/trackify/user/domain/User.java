package com.example.trackify.user.domain;

import com.example.trackify.task.domain.Task;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name = "user_nickname", length = 50, nullable = false)
    private String userNickname;

    @Column(name = "user_password", length = 50, nullable = false)
    private String userPassword;

    @Column(name = "user_status", nullable = false, columnDefinition = "INT DEFAULT 1")
    private int userStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

}
