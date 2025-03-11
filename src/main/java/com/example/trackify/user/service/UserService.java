package com.example.trackify.user.service;

import com.example.trackify.user.domain.User;
import com.example.trackify.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(String userId, String userNickname, String userPassword) {
        User user = new User();
        user.setUserId(userId);
        user.setUserNickname(userNickname);
        user.setUserPassword(userPassword);
        user.setUserStatus(1);
        return userRepository.save(user);
    }

    public User findByUserId(String userId, String userPassword) {
        return userRepository.findByUserIdAndUserPassword(userId, userPassword)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 사용자 정보입니다."));
    }

}
