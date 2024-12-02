package com.project.funding.repository;

import com.project.funding.model.RoleName;
import com.project.funding.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * RoleRepository
 * 역할 데이터를 처리하는 리포지토리 인터페이스
 */
@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByName(RoleName roleName); // 역할 이름으로 검색
}
