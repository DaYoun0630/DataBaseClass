package com.project.funding.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // 사용자 ID를 포함하는 더미 토큰 생성
    public String generateToken(String userId) {
        return "Bearer " + userId; // 단순히 "Bearer {userId}" 형태로 반환
    }

    // 토큰에서 사용자 ID 추출
    public String getUserIdFromJWT(String token) {
        try {
            // 토큰 파싱 로직
            return token.substring(7); // "Bearer " 제거 후 반환
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid token", e);
        }
    }

    // 토큰 유효성 검사 (항상 true 반환)
    public boolean validateToken(String authToken) {
        return authToken != null && authToken.startsWith("Bearer ");
    }
}
