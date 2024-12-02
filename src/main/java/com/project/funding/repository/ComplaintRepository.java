package com.project.funding.repository;

import com.project.funding.model.Complaint;
import com.project.funding.model.ComplaintState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // 특정 상태의 민원을 조회하는 메서드
    List<Complaint> findByState(ComplaintState state);
}
