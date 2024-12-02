package com.project.funding.service;

import com.project.funding.model.Category;
import com.project.funding.model.ProjectApplication;
import com.project.funding.model.ProjectApplicationState;
import com.project.funding.repository.ProjectApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 프로젝트 신청 관련 비즈니스 로직 처리
@Service
public class ProjectApplicationService {

    @Autowired
    private ProjectApplicationRepository projectApplicationRepository;

    // 특정 카테고리와 상태의 프로젝트 조회
    public List<ProjectApplication> getProjectsByCategory(Category category) {
        return projectApplicationRepository.findByCategoryAndState(category, ProjectApplicationState.APPROVED);
    }
}
