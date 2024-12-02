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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    private StateManagementService stateManagementService;

    @Autowired
    private ProjectApplicationRepository projectApplicationRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @PutMapping("/project/{id}/state")
    public String updateProjectState(@PathVariable Long id, @RequestParam ProjectApplicationState newState) {
        ProjectApplication project = projectApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProjectApplication", "id", id));

        stateManagementService.updateState(project, newState);
        return "Project state updated to " + newState.getStateName();
    }

    @PutMapping("/complaint/{id}/state")
    public String updateComplaintState(@PathVariable Long id, @RequestParam ComplaintState newState) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint", "id", id));

        stateManagementService.updateState(complaint, newState);
        return "Complaint state updated to " + newState.getStateName();
    }
}