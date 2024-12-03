package com.project.funding.controller;

import com.project.funding.model.ProjectApplication;
import com.project.funding.service.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/auth")
public class ProjectApplicationController {

    @Autowired
    private ProjectApplicationService projectApplicationService;

    // JSON 데이터를 반환하는 REST API
    @GetMapping("/project")
    @ResponseBody
    public List<ProjectApplication> getAllProjects() {
        return projectApplicationService.getAllProjects();
    }

    // HTML 페이지 렌더링
    @GetMapping("/projects")
    public String getProjectsPage(Model model) {
        model.addAttribute("projects", projectApplicationService.getAllProjects());
        return "projects"; // projects.html 렌더링
    }
}
