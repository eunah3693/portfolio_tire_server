package com.portfolio.tire_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 엔드포인트에 대해
                .allowedOrigins(
                    "http://localhost:3000",
                    "http://43.203.60.53",  // AWS 서버 도메인
                    "https://43.203.60.53"  // HTTPS도 추가
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 허용할 HTTP 메서드
                .allowedHeaders("*")  // 모든 헤더 허용
                .exposedHeaders("Authorization")  // 인증 헤더 노출
                .allowCredentials(true)  // 인증 정보 허용
                .maxAge(3600);  // preflight 요청의 캐시 시간
    }
} 