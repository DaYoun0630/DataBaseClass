package com.project.funding.repository;

import com.project.funding.model.ProjectApplication;
import com.project.funding.model.Category;
import com.project.funding.model.ProjectApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// 프로젝트 신청 데이터를 처리하는 리포지토리
@Repository
public interface ProjectApplicationRepository extends JpaRepository<ProjectApplication, Long> {

    // 특정 카테고리의 승인된 프로젝트 조회
    List<ProjectApplication> findByCategoryAndState(Category category, ProjectApplicationState state);
}
