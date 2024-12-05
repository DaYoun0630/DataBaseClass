package com.project.funding.payload;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 프로젝트 등록 요청 데이터
 * 클라이언트가 프로젝트 등록 요청 시 전달하는 데이터를 포함
 */
public class ProjectRegistrationRequest {

    @NotNull(message = "카테고리 ID는 필수입니다.")
    private Integer categoryId; // 카테고리 ID

    @NotNull(message = "프로젝트 신청 ID는 필수입니다.")
    private Long projectApplicationId; // 프로젝트 신청 ID

    @NotNull(message = "목표 금액은 필수입니다.")
    private BigDecimal goalAmount; // 목표 금액

    // Getter와 Setter
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
}

