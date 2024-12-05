package com.project.funding.model;

import com.project.funding.repository.StatefulEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 결제(Payment) 정보를 나타내는 엔터티 클래스
 * 상태 관리(StatefulEntity<PaymentState>)와 연계하여 결제 상태를 관리
 */
@Entity
@Table(name = "payments")
public class Payment implements StatefulEntity<PaymentState> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id; // 결제 ID (Primary Key)

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod; // 결제 방식 (예: 카드, 계좌이체 등)

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount; // 결제 금액

    @Column(name = "details", columnDefinition = "TEXT")
    private String details; // 결제 관련 추가 세부 사항 (선택적 필드)

    @Column(name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now(); // 결제 일시

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private PaymentState state = PaymentState.PENDING; // 기본 상태: PENDING

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sponsorship_application_id", nullable = false)
    private SponsorshipApplication sponsorshipApplication; // 연관된 후원 신청


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Column(name = "category_id", nullable = false)
    private Category category; // 결제가 속한 카테고리 ID

    // 기본 생성자
    public Payment() {}

    // Getter 및 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public SponsorshipApplication getSponsorshipApplication() {
        return sponsorshipApplication;
    }

    public void setSponsorshipApplication(SponsorshipApplication sponsorshipApplication) {
        this.sponsorshipApplication = sponsorshipApplication;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // 상태 관리 메서드 (StatefulEntity 인터페이스 구현)
    @Override
    public PaymentState getState() {
        return state;
    }

    @Override
    public void setState(PaymentState state) {
        this.state = state;
    }
}
