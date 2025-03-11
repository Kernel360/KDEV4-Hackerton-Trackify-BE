package com.example.trackify.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionUserId = (String) request.getSession().getAttribute("userId");

        // 세션에 user_id가 없는 경우 (로그인 안 된 경우)
        if (sessionUserId == null) {
            response.sendRedirect("/");  // 메인으로 리다이렉트
            return false;
        }

        return true;  // 계속 진행
    }
}

