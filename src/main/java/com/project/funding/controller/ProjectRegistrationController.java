package com.project.funding.controller;

import com.project.funding.model.ProjectRegistration;
import com.project.funding.service.ProjectRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projects") // API 기본 경로 설정
public class ProjectRegistrationController {

    @Autowired
    private ProjectRegistrationService projectRegistrationService;

    // 모든 프로젝트 조회
    @GetMapping
    public ResponseEntity<List<ProjectRegistration>> getAllProjects() {
        List<ProjectRegistration> projects = projectRegistrationService.getAllProjects();
        return ResponseEntity.ok(projects); // HTTP 200 응답과 함께 프로젝트 목록 반환
    }

    // 특정 프로젝트 조회
    @GetMapping("/{id}")
    public ResponseEntity<ProjectRegistration> getProjectById(@PathVariable Long id) {
        ProjectRegistration project = projectRegistrationService.getProjectById(id);
        return ResponseEntity.ok(project); // HTTP 200 응답과 함께 프로젝트 반환
    }

    // 새로운 프로젝트 등록
    @PostMapping
    public ResponseEntity<ProjectRegistration> createProject(
            @Valid @RequestBody ProjectRegistration projectRegistration) {
        ProjectRegistration createdProject = projectRegistrationService.createProject(projectRegistration);
        return ResponseEntity.ok(createdProject); // HTTP 200 응답과 함께 생성된 프로젝트 반환
    }

    // 프로젝트 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<ProjectRegistration> updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRegistration updatedProject) {
        ProjectRegistration updated = projectRegistrationService.updateProject(id, updatedProject);
        return ResponseEntity.ok(updated); // HTTP 200 응답과 함께 업데이트된 프로젝트 반환
    }

    // 프로젝트 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectRegistrationService.deleteProject(id);
        return ResponseEntity.ok("Project deleted successfully."); // HTTP 200 응답과 함께 삭제 확인 메시지 반환
    }
}

