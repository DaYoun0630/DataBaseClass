package com.project.funding.repository;

import com.project.funding.model.SponsorshipApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorshipApplicationRepository extends JpaRepository<SponsorshipApplication, Long> {

    // 특정 프로젝트에 속한 후원 신청 조회
    List<SponsorshipApplication> findByProjectId(Long projectId);

    // 특정 사용자가 신청한 후원 조회
    List<SponsorshipApplication> findByUserId(String userId);

    // 특정 후원 관리 ID로 조회
    List<SponsorshipApplication> findBySponsorshipId(Long sponsorshipId);

    // 특정 프로젝트와 특정 사용자의 후원 조회
    List<SponsorshipApplication> findByProjectIdAndUserId(Long projectId, String userId);
}
