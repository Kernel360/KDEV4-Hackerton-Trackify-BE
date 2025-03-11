package com.example.trackify.category.domain;

public enum CategoryStatus {
    IN_PROGRESS(1),
    EARLY_COMPLETED(2),
    COMPLETED(3);

    private final int value;

    CategoryStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
