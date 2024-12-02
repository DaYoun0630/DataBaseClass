package com.project.funding.config;

import com.project.funding.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing // JPA Auditing 활성화
public class AuditingConfig {

    /**
     * AuditorAware 빈 등록
     * - JPA Auditing 기능에서 현재 인증된 사용자를 가져오는 데 사용
     */
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new SpringSecurityAuditAwareImpl(); // 사용자 ID를 반환하는 AuditorAware 구현체
    }
}

/**
 * 현재 인증된 사용자의 ID를 반환하는 AuditorAware 구현체
 * - JPA Auditing 기능에서 CreatedBy, LastModifiedBy 필드를 자동으로 채우기 위해 사용
 */
class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

    /**
     * 현재 인증된 사용자의 ID 반환
     *
     * @return Optional<Long> 사용자 ID (없을 경우 Optional.empty())
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        // 현재 인증 객체 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증 객체가 없거나 익명 사용자일 경우 Optional.empty 반환
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }

        // 인증된 사용자 정보에서 ID 추출
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getUserId());
    }
}
