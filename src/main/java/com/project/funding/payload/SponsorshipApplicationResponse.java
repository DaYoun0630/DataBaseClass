package com.project.funding.payload;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 후원 신청 응답 데이터
 * 클라이언트가 후원 신청 요청 후 서버로부터 받는 데이터 구조
 */
public class SponsorshipApplicationResponse {

    private Long sponsorshipApplicationId; // 후원 신청 ID
    private Long projectId; // 후원한 프로젝트 ID
    private String projectName; // 후원한 프로젝트 이름
    private String userId; // 후원한 사용자 ID
    private BigDecimal amount; // 후원 금액
    private String method; // 결제 방식
    private String details; // 추가 세부 사항
    private LocalDateTime date; // 후원 신청 날짜

    // 기본 생성자
    public SponsorshipApplicationResponse() {}

    // Getter와 Setter
    public Long getSponsorshipApplicationId() {
        return sponsorshipApplicationId;
    }

    public void setSponsorshipApplicationId(Long sponsorshipApplicationId) {
        this.sponsorshipApplicationId = sponsorshipApplicationId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
