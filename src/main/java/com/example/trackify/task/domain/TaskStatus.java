package com.example.trackify.task.domain;

public enum TaskStatus {
    IN_PROGRESS(1),
    EARLY_COMPLETED(2),
    COMPLETED(3);

    private final int value;

    TaskStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TaskStatus fromValue(int value) {
        for (TaskStatus status : values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus value: " + value);
    }
}
