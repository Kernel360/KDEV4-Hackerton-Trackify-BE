package com.example.trackify.todo.domain;

public enum TodoStatus {
    CHECKED(true),
    UNCHECKED(false);

    private final boolean value;

    TodoStatus(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
