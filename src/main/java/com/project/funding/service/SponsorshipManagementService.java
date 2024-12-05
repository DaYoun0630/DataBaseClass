package com.project.funding.service;

import com.project.funding.model.ProjectRegistration;
import com.project.funding.model.SponsorshipManagement;
import com.project.funding.repository.ProjectRegistrationRepository;
import com.project.funding.repository.SponsorshipManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class SponsorshipManagementService {

    @Autowired
    private SponsorshipManagementRepository sponsorshipManagementRepository;

    @Autowired
    private ProjectRegistrationRepository projectRegistrationRepository;

    // 특정 프로젝트의 후원 관리 정보 조회
    @Transactional
    public SponsorshipManagement getSponsorshipByProjectId(Long projectId) {
        return sponsorshipManagementRepository.findByProjectId(projectId)
                .orElseThrow(() -> new RuntimeException("Sponsorship Management not found for project ID: " + projectId));
    }

    // 실시간 후원 금액 업데이트
    @Transactional
    public SponsorshipManagement updateRealTimeDonationAmount(Long projectId, BigDecimal newDonationAmount) {
        SponsorshipManagement sponsorshipManagement = sponsorshipManagementRepository.findByProjectId(projectId)
                .orElseThrow(() -> new RuntimeException("Sponsorship Management not found for project ID: " + projectId));

        // 새로운 금액 추가
        BigDecimal updatedAmount = sponsorshipManagement.getRealTimeDonationAmount().add(newDonationAmount);
        sponsorshipManagement.setRealTimeDonationAmount(updatedAmount);

        // 저장 및 반환
        return sponsorshipManagementRepository.save(sponsorshipManagement);
    }

    // 후원 관리 데이터 생성
    @Transactional
    public SponsorshipManagement createSponsorshipManagement(Long projectId) {
        // 프로젝트 조회
        ProjectRegistration project = projectRegistrationRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));

        // 새로운 SponsorshipManagement 생성
        SponsorshipManagement sponsorshipManagement = new SponsorshipManagement();
        sponsorshipManagement.setProject(project); // Project 객체 설정
        sponsorshipManagement.setRealTimeDonationAmount(BigDecimal.ZERO); // 초기 금액 설정

        // 저장 및 반환
        return sponsorshipManagementRepository.save(sponsorshipManagement);
    }
}
