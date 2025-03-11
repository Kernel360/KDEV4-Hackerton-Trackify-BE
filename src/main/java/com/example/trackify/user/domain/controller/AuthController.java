package com.example.trackify.user.domain.controller;

import com.example.trackify.user.domain.entity.User;
import com.example.trackify.user.domain.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public User register(@RequestBody Map<String, String> request) {
        return userService.registerUser(request.get("userId"), request.get("userNickname"), request.get("userPassword"));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> request, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        try {
            User user = userService.findByUserId(request.get("userId"), request.get("userPassword"));

            session.setAttribute("userId", user.getUserId()); // 세션에 저장

            response.put("message", "로그인 성공");
            response.put("userId", user.getUserId());
            response.put("sessionId", session.getId()); // 세션 ID 반환

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("message", "로그인 실패");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
