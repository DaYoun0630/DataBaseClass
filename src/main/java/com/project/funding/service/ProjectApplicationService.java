package com.project.funding.service;

import com.project.funding.dto.ProjectApplicationDto;
import com.project.funding.model.ProjectApplication;
import com.project.funding.repository.ProjectApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectApplicationService {

    @Autowired
    private ProjectApplicationRepository projectApplicationRepository;

    // 모든 프로젝트 조회
    public List<ProjectApplication> getAllProjects() {
        return projectApplicationRepository.findAll();
    }

    // ID로 특정 프로젝트 조회
    public ProjectApplicationDto getProjectById(String id) { // id 타입 변경
        return projectApplicationRepository.findById(Long.valueOf(id))
                .map(project -> new ProjectApplicationDto(
                        project.getProjectApplicationId(),
                        project.getProjectName(),
                        project.getProjectDescription(),
                        project.getProjectStartDate(),
                        project.getProjectEndDate(),
                        project.getProjectTargetAmount(),
                        project.getCategoryId(),
                        project.getProjectApplicationDate()
                )).orElse(null);
    }
}

