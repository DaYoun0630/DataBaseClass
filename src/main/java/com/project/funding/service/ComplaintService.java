package com.project.funding.service;

import com.project.funding.exception.ResourceNotFoundException;
import com.project.funding.model.Complaint;
import com.project.funding.model.ComplaintState;
import com.project.funding.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public List<Complaint> getComplaintsByState(ComplaintState state) {
        return complaintRepository.findByState(state);
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint", "id", id));
    }

    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }
}

