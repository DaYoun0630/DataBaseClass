package com.project.funding.controller;

import com.project.funding.model.SponsorshipManagement;
import com.project.funding.payload.ApiResponse;
import com.project.funding.service.SponsorshipManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/sponsorship-management") // API 기본 경로
public class SponsorshipManagementController {

    @Autowired
    private SponsorshipManagementService sponsorshipManagementService;

    // 특정 프로젝트의 후원 관리 정보 조회
    @GetMapping("/project/{projectId}")
    public ResponseEntity<SponsorshipManagement> getSponsorshipByProjectId(@PathVariable Long projectId) {
        SponsorshipManagement sponsorship = sponsorshipManagementService.getSponsorshipByProjectId(projectId);
        return ResponseEntity.ok(sponsorship);
    }

    // 실시간 후원 금액 업데이트
    @PutMapping("/project/{projectId}/update-donation")
    public ResponseEntity<ApiResponse> updateRealTimeDonationAmount(
            @PathVariable Long projectId,
            @RequestParam BigDecimal newDonationAmount
    ) {
        sponsorshipManagementService.updateRealTimeDonationAmount(projectId, newDonationAmount);
        return ResponseEntity.ok(new ApiResponse(true, "Donation amount updated successfully."));
    }

    // 새로운 후원 관리 데이터 생성
    @PostMapping("/project/{projectId}/create")
    public ResponseEntity<ApiResponse> createSponsorshipManagement(@PathVariable Long projectId) {
        sponsorshipManagementService.createSponsorshipManagement(projectId);
        return ResponseEntity.ok(new ApiResponse(true, "Sponsorship Management created successfully."));
    }
}
