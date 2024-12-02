package com.project.funding.controller;

import com.project.funding.model.Category;
import com.project.funding.model.ProjectApplication;
import com.project.funding.service.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 프로젝트 관련 API를 제공하는 컨트롤러
@RestController
@RequestMapping("/api/projects")
public class ProjectApplicationController {

    @Autowired
    private ProjectApplicationService projectApplicationService;

    // 카테고리별 승인된 프로젝트 조회
    @GetMapping("/category/{categoryId}")
    public List<ProjectApplication> getProjectsByCategory(@PathVariable Long categoryId) {
        Category category = new Category(); // 카테고리 객체 생성
        category.setId(categoryId); // ID 설정
        return projectApplicationService.getProjectsByCategory(category); // 서비스 호출
    }
}
