package com.example.trackify.user.domain;

public enum UserStatus {
    ACTIVE(1), //정상 회원
    SUSPENDED(2), //정지 회원
    PENALIZED(3), //제재 회원
    WITHDRAWN(4); //탈퇴 회원

    private final int value;

    UserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
