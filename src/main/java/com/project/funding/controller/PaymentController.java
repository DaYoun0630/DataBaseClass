package com.project.funding.controller;

import com.project.funding.model.Payment;
import com.project.funding.model.PaymentState;
import com.project.funding.payload.ApiResponse;
import com.project.funding.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/payments") // 결제 API의 기본 경로
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // 새로운 결제 생성
    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @RequestParam Long sponsorshipApplicationId,
            @RequestParam String paymentMethod,
            @RequestParam BigDecimal amount,
            @RequestParam(required = false) String details
    ) {
        Payment payment = paymentService.createPayment(sponsorshipApplicationId, paymentMethod, amount, details);
        return ResponseEntity.ok(payment);
    }

    // 특정 후원 신청의 결제 정보 조회
    @GetMapping("/sponsorship/{sponsorshipApplicationId}")
    public ResponseEntity<List<Payment>> getPaymentsBySponsorshipApplication(
            @PathVariable Long sponsorshipApplicationId
    ) {
        List<Payment> payments = paymentService.getPaymentsBySponsorshipApplication(sponsorshipApplicationId);
        return ResponseEntity.ok(payments);
    }

    // 특정 결제 상태의 결제 정보 조회
    @GetMapping("/state/{state}")
    public ResponseEntity<List<Payment>> getPaymentsByState(@PathVariable PaymentState state) {
        List<Payment> payments = paymentService.getPaymentsByState(state);
        return ResponseEntity.ok(payments);
    }

    // 결제 상태 업데이트
    @PutMapping("/{paymentId}/state")
    public ResponseEntity<ApiResponse> updatePaymentState(
            @PathVariable Long paymentId,
            @RequestParam PaymentState newState
    ) {
        paymentService.updatePaymentState(paymentId, newState);
        return ResponseEntity.ok(new ApiResponse(true, "Payment state updated successfully."));
    }
}
