package com.project.funding.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 후원 신청 요청 데이터
 * 클라이언트가 후원 신청 시 전달하는 데이터 구조
 */
public class SponsorshipApplicationRequest {

    @NotNull(message = "프로젝트 ID는 필수입니다.")
    private Long projectId; // 후원할 프로젝트 ID

    @NotNull(message = "후원 금액은 필수입니다.")
    private BigDecimal amount; // 후원 금액

    @NotBlank(message = "결제 방식은 필수입니다.")
    private String method; // 결제 방식 (예: 카드, 계좌이체 등)

    private String details; // 추가 세부 사항 (선택적 필드)

    private LocalDateTime date = LocalDateTime.now(); // 후원 신청 날짜 (기본값: 현재 시간)

    // 기본 생성자
    public SponsorshipApplicationRequest() {}

    // Getter와 Setter
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
}
