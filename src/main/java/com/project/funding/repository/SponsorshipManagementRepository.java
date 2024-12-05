package com.project.funding.repository;

import com.project.funding.model.SponsorshipManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SponsorshipManagementRepository extends JpaRepository<SponsorshipManagement, Long> {

    // 특정 프로젝트의 후원 관리 정보 조회
    Optional<SponsorshipManagement> findByProjectId(Long projectId);
}
