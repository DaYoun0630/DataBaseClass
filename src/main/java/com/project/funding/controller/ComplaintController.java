package com.project.funding.controller;

import com.project.funding.model.Complaint;
import com.project.funding.model.ComplaintState;
import com.project.funding.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/state")
    public List<Complaint> getComplaintsByState(@RequestParam ComplaintState state) {
        return complaintService.getComplaintsByState(state);
    }

    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }
}
