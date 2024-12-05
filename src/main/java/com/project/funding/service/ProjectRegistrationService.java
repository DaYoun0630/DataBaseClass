package com.project.funding.service;

import com.project.funding.model.ProjectRegistration;
import com.project.funding.repository.ProjectRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectRegistrationService {

    @Autowired
    private ProjectRegistrationRepository projectRegistrationRepository;

    // 프로젝트 등록
    public ProjectRegistration createProject(ProjectRegistration projectRegistration) {
        // 프로젝트 유효성 검사 로직 추가 가능
        return projectRegistrationRepository.save(projectRegistration);
    }

    // 모든 프로젝트 조회
    public List<ProjectRegistration> getAllProjects() {
        return projectRegistrationRepository.findAll();
    }

    // 특정 프로젝트 조회 (ID 기반)
    public ProjectRegistration getProjectById(Long projectId) {
        return projectRegistrationRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));
    }

    // 프로젝트 삭제
    public void deleteProject(Long projectId) {
        // 존재 여부 확인
        if (!projectRegistrationRepository.existsById(projectId)) {
            throw new RuntimeException("Project not found with ID: " + projectId);
        }
        projectRegistrationRepository.deleteById(projectId);
    }

    // 프로젝트 업데이트
    public ProjectRegistration updateProject(Long projectId, ProjectRegistration updatedProject) {
        // 기존 프로젝트 확인
        ProjectRegistration existingProject = projectRegistrationRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));

        // 필드 업데이트
        existingProject.setCategory(updatedProject.getCategory());
        existingProject.setProjectApplication(updatedProject.getProjectApplication());
        existingProject.setCreatedAt(updatedProject.getCreatedAt());
        existingProject.setGoalAmount(updatedProject.getGoalAmount());

        return projectRegistrationRepository.save(existingProject);
    }
}

