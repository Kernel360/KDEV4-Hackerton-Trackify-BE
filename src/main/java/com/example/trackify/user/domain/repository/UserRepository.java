package com.example.trackify.user.domain.repository;

import com.example.trackify.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserIdAndUserPassword(String userId, String userPassword);
}
