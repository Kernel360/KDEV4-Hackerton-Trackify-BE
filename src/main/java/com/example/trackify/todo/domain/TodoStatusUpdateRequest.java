package com.example.trackify.todo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoStatusUpdateRequest {
    private Boolean todoCheck;
}
