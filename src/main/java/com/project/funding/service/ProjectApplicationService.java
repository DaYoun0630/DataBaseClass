package com.project.funding.service;

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
}
