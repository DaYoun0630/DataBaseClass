package com.project.funding.controller;

import com.project.funding.exception.ResourceNotFoundException;
import com.project.funding.model.Complaint;
import com.project.funding.model.ComplaintState;
import com.project.funding.model.ProjectApplication;
import com.project.funding.model.ProjectApplicationState;
import com.project.funding.repository.ComplaintRepository;
import com.project.funding.repository.ProjectApplicationRepository;
import com.project.funding.service.StateManagementService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*; // Spring MVC 어노테이션 제거

//@RestController // RestController 비활성화
//@RequestMapping("/api/state") // RequestMapping 비활성화
public class StateController {

    @Autowired
    private StateManagementService stateManagementService;

    @Autowired
    private ProjectApplicationRepository projectApplicationRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    //@PutMapping("/project/{id}/state") // 상태 변경 메서드 비활성화
    public String updateProjectState(Long id, ProjectApplicationState newState) {
        ProjectApplication project = projectApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProjectApplication", "id", id));

        stateManagementService.updateState(project, newState);
        return "Project state updated to " + newState.getStateName();
    }

    //@PutMapping("/complaint/{id}/state") // 상태 변경 메서드 비활성화
//    public String updateComplaintState(Long id, ComplaintState newState) {
//        Complaint complaint = complaintRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Complaint", "id", id));
//
//        stateManagementService.updateState(complaint, newState);
//        return "Complaint state updated to " + newState.getStateName();
//    }
}
