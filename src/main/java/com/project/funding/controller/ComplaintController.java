package com.project.funding.controller;

import com.project.funding.model.Complaint;
import com.project.funding.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // 모든 민원 데이터를 반환하는 엔드포인트
    @GetMapping("/complaints")
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    // /api/complaint 경로에서도 동일하게 데이터를 반환
    @GetMapping("/complaint")
    public List<Complaint> getAllComplaintsAlias() {
        return complaintService.getAllComplaints();
    }
}


