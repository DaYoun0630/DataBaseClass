package com.project.funding.service;

import com.project.funding.model.SponsorshipApplication;
import com.project.funding.model.ProjectRegistration;
import com.project.funding.model.User;
import com.project.funding.payload.SponsorshipApplicationRequest;
import com.project.funding.repository.SponsorshipApplicationRepository;
import com.project.funding.repository.ProjectRegistrationRepository;
import com.project.funding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SponsorshipApplicationService {

    @Autowired
    private SponsorshipApplicationRepository sponsorshipApplicationRepository;

    @Autowired
    private ProjectRegistrationRepository projectRegistrationRepository;

    @Autowired
    private UserRepository userRepository;

    // 후원 신청 생성
    @Transactional
    public SponsorshipApplication createSponsorship(SponsorshipApplicationRequest request, String userId) {
        // 사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // 프로젝트 조회
        ProjectRegistration project = projectRegistrationRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + request.getProjectId()));

        // 새로운 후원 신청 생성
        SponsorshipApplication sponsorship = new SponsorshipApplication();
        sponsorship.setProject(project);
        sponsorship.setUser(user);
        sponsorship.setAmount(request.getAmount());
        sponsorship.setMethod(request.getMethod());
        sponsorship.setDetails(request.getDetails());
        sponsorship.setDate(request.getDate());

        // 후원 신청 저장
        return sponsorshipApplicationRepository.save(sponsorship);
    }

    // 특정 프로젝트의 후원 신청 조회
    @Transactional(readOnly = true)
    public List<SponsorshipApplication> getSponsorshipsByProject(Long projectId) {
        return sponsorshipApplicationRepository.findByProjectId(projectId);
    }

    // 특정 사용자의 후원 신청 조회
    @Transactional(readOnly = true)
    public List<SponsorshipApplication> getSponsorshipsByUser(String userId) {
        return sponsorshipApplicationRepository.findByUserId(userId);
    }

    // 특정 후원 관리 ID로 후원 신청 조회
    @Transactional(readOnly = true)
    public List<SponsorshipApplication> getSponsorshipsBySponsorshipId(Long sponsorshipId) {
        return sponsorshipApplicationRepository.findBySponsorshipId(sponsorshipId);
    }

    // 특정 프로젝트에서 특정 사용자가 신청한 후원 조회
    @Transactional(readOnly = true)
    public List<SponsorshipApplication> getSponsorshipsByProjectAndUser(Long projectId, String userId) {
        return sponsorshipApplicationRepository.findByProjectIdAndUserId(projectId, userId);
    }

    // 후원 신청 삭제
    @Transactional
    public void deleteSponsorship(Long sponsorshipApplicationId) {
        SponsorshipApplication sponsorship = sponsorshipApplicationRepository.findById(sponsorshipApplicationId)
                .orElseThrow(() -> new RuntimeException("Sponsorship not found with ID: " + sponsorshipApplicationId));
        sponsorshipApplicationRepository.delete(sponsorship);
    }
}
