package com.project.funding.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // JWT 토큰 생성 (더 이상 사용하지 않음)
    public String generateToken(Object authentication) {
        return "dummy-token"; // 더미 토큰 반환
    }

    // 토큰에서 사용자 ID 추출 (더 이상 사용하지 않음)
    public String getUserIdFromJWT(String token) {
        return "dummy-user-id"; // 더미 사용자 ID 반환
    }

    /**
     * JWT 토큰 유효성 검사 (항상 true 반환)
     * @param authToken JWT 토큰
     * @return 유효 여부
     */
    public boolean validateToken(String authToken) {
        return true; // 항상 유효한 토큰으로 간주
    }
}
