package com.project.funding.payload;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 프로젝트 등록 응답 데이터
 * 클라이언트가 프로젝트 등록 후 서버로부터 받는 데이터 구조
 */
public class ProjectRegistrationResponse {

    private Long projectId; // 프로젝트 ID
    private Integer categoryId; // 카테고리 ID
    private Long projectApplicationId; // 프로젝트 신청 ID
    private BigDecimal goalAmount; // 목표 금액
    private LocalDateTime createdAt; // 생성 날짜

    // 기본 생성자
    public ProjectRegistrationResponse() {}

    // Getter와 Setter
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(Long projectApplicationId) {
        this.projectApplicationId = projectApplicationId;
    }

    public BigDecimal getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(BigDecimal goalAmount) {
        this.goalAmount = goalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
