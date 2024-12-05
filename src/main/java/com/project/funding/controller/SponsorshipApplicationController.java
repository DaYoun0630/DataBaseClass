package com.project.funding.controller;

import com.project.funding.model.SponsorshipApplication;
import com.project.funding.payload.ApiResponse;
import com.project.funding.payload.SponsorshipApplicationRequest;
import com.project.funding.security.CurrentUser;
import com.project.funding.security.UserPrincipal;
import com.project.funding.service.SponsorshipApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sponsorships") // 후원 신청 API 기본 경로
public class SponsorshipApplicationController {

    @Autowired
    private SponsorshipApplicationService sponsorshipApplicationService;

    // 새로운 후원 신청 생성
    @PostMapping
    @PreAuthorize("hasRole('USER')") // USER 권한이 있어야 접근 가능
    public ResponseEntity<?> createSponsorship(
            @Valid @RequestBody SponsorshipApplicationRequest request,
            @CurrentUser UserPrincipal currentUser // 현재 로그인한 사용자 정보
    ) {
        SponsorshipApplication sponsorship = sponsorshipApplicationService.createSponsorship(request, currentUser.getUserId());
        return ResponseEntity.ok(new ApiResponse(true, "Sponsorship created successfully."));
    }

    // 특정 프로젝트의 모든 후원 신청 조회
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<SponsorshipApplication>> getSponsorshipsByProject(@PathVariable Long projectId) {
        List<SponsorshipApplication> sponsorships = sponsorshipApplicationService.getSponsorshipsByProject(projectId);
        return ResponseEntity.ok(sponsorships);
    }

    // 특정 사용자의 모든 후원 신청 조회
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == principal.id") // ADMIN이거나 본인만 접근 가능
    public ResponseEntity<List<SponsorshipApplication>> getSponsorshipsByUser(@PathVariable String userId) {
        List<SponsorshipApplication> sponsorships = sponsorshipApplicationService.getSponsorshipsByUser(userId);
        return ResponseEntity.ok(sponsorships);
    }

    // 특정 후원 신청 삭제
    @DeleteMapping("/{sponsorshipApplicationId}")
    @PreAuthorize("hasRole('USER')") // USER 권한이 있어야 접근 가능
    public ResponseEntity<?> deleteSponsorship(
            @PathVariable Long sponsorshipApplicationId,
            @CurrentUser UserPrincipal currentUser
    ) {
        sponsorshipApplicationService.deleteSponsorship(sponsorshipApplicationId);
        return ResponseEntity.ok(new ApiResponse(true, "Sponsorship deleted successfully."));
    }
}
