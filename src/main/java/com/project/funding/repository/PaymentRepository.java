package com.project.funding.repository;

import com.project.funding.model.Payment;
import com.project.funding.model.PaymentState;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // 특정 후원 신청에 해당하는 결제 정보 조회
    List<Payment> findBySponsorshipApplicationId(Long sponsorshipApplicationId);

    // 특정 카테고리에 속한 결제 정보 조회
    List<Payment> findByCategoryId(Long categoryId);

    // 특정 결제 상태를 가진 결제 정보 조회
    List<Payment> findByState(PaymentState state);
}
