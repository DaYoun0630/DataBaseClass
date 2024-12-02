package com.project.funding.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // JWT 인증 로직 비활성화: 요청을 그대로 전달합니다.
            logger.info("JWT 인증 필터 비활성화: 요청이 인증 없이 처리됩니다.");
        } catch (Exception ex) {
            logger.error("필터 처리 중 오류 발생", ex);
        }

        // 다음 필터로 요청 전달
        filterChain.doFilter(request, response);
    }
}
