package com.project.funding.controller;

import com.project.funding.model.ProjectApplication;
import com.project.funding.service.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectApplicationController {

    @Autowired
    private ProjectApplicationService projectApplicationService;

    @GetMapping("/api/auth/project")
    public String getProjects(Model model) {
        model.addAttribute("projects", projectApplicationService.getAllProjects());
        return "projects"; // projects.html 렌더링
    }

    @ResponseBody
    public List<ProjectApplication> getAllProjects() {
        return projectApplicationService.getAllProjects();
    }
}
