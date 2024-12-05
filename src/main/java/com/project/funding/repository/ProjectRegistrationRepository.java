package com.project.funding.repository;

import com.project.funding.model.Category;
import com.project.funding.model.ProjectRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRegistrationRepository extends JpaRepository<ProjectRegistration, Long> {

    // 특정 카테고리의 프로젝트 조회 (Category 객체 활용)
    List<ProjectRegistration> findByCategory(Category category);

    // 목표 금액 이상 달성한 프로젝트 조회
    List<ProjectRegistration> findByGoalAmountGreaterThanEqual(Double goalAmount);

    // 특정 기간 동안 생성된 프로젝트 조회
    List<ProjectRegistration> findByCreationDateBetween(
            java.time.LocalDateTime startDate,
            java.time.LocalDateTime endDate
    );
}
