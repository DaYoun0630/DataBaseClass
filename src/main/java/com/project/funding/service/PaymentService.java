package com.project.funding.service;

import com.project.funding.model.Payment;
import com.project.funding.model.PaymentState;
import com.project.funding.model.SponsorshipApplication;
import com.project.funding.repository.PaymentRepository;
import com.project.funding.repository.SponsorshipApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SponsorshipApplicationRepository sponsorshipApplicationRepository;

    // 새로운 결제 생성
    @Transactional
    public Payment createPayment(Long sponsorshipApplicationId, String paymentMethod, BigDecimal amount, String details) {
        // 후원 신청 조회
        SponsorshipApplication sponsorshipApplication = sponsorshipApplicationRepository.findById(sponsorshipApplicationId)
                .orElseThrow(() -> new RuntimeException("Sponsorship Application not found with ID: " + sponsorshipApplicationId));

        // 새로운 결제 객체 생성
        Payment payment = new Payment();
        payment.setSponsorshipApplication(sponsorshipApplication);
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setDetails(details);
        payment.setState(PaymentState.PENDING); // 기본 상태 설정

        // 저장 및 반환
        return paymentRepository.save(payment);
    }

    // 결제 상태 업데이트
    @Transactional
    public Payment updatePaymentState(Long paymentId, PaymentState newState) {
        // 결제 정보 조회
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));

        // 상태 업데이트
        payment.setState(newState);

        // 저장 및 반환
        return paymentRepository.save(payment);
    }

    // 특정 후원 신청과 연결된 결제 정보 조회
    @Transactional(readOnly = true)
    public List<Payment> getPaymentsBySponsorshipApplication(Long sponsorshipApplicationId) {
        return paymentRepository.findBySponsorshipApplicationId(sponsorshipApplicationId);
    }

    // 특정 결제 상태의 결제 정보 조회
    @Transactional(readOnly = true)
    public List<Payment> getPaymentsByState(PaymentState state) {
        return paymentRepository.findByState(state);
    }
}
