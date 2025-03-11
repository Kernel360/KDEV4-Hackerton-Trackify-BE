package com.example.trackify.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/**")   // 보호할 URL 패턴
                .addPathPatterns("/task/**")
                .excludePathPatterns("/", "/login", "/signup");  // 예외 (로그인, 회원가입 페이지는 제외)
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://3.37.130.205:3000")  // React 배포 URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowCredentials(true) // 세션 & 쿠키 허용
                .allowedHeaders("*"); // 모든 헤더 허용
    }
}

