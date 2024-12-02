package com.project.funding.repository;

import com.project.funding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // 사용자 ID로 사용자 찾기
    Optional<User> findByUserId(String userId);

    // 사용자 ID 중복 확인
    boolean existsByUserId(String userId);

    // 사용자 이름 중복 확인
    boolean existsByUserName(String userName);
}
