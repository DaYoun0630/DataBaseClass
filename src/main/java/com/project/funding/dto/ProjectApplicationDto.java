package com.project.funding.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProjectApplicationDto {
    private String projectApplicationId; // varchar(36)
    private String projectName; // varchar(100)
    private String projectDescription; // text
    private LocalDate projectStartDate; // date
    private LocalDate projectEndDate; // date
    private BigDecimal projectTargetAmount; // decimal(10,2)
    private Long categoryId; // bigint
    private LocalDateTime projectApplicationDate; // datetime

    // 생성자
    public ProjectApplicationDto(Long projectApplicationId, String projectName, String projectDescription,
                                 LocalDate projectStartDate, LocalDate projectEndDate, BigDecimal projectTargetAmount,
                                 Integer categoryId, LocalDate projectApplicationDate) {
        this.projectApplicationId = String.valueOf(projectApplicationId);
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectTargetAmount = projectTargetAmount;
        this.categoryId = Long.valueOf(categoryId);
        this.projectApplicationDate = projectApplicationDate.atStartOfDay();
    }

    // Getter와 Setter
    public String getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(String projectApplicationId) {
        this.projectApplicationId = projectApplicationId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public LocalDate getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(LocalDate projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public BigDecimal getProjectTargetAmount() {
        return projectTargetAmount;
    }

    public void setProjectTargetAmount(BigDecimal projectTargetAmount) {
        this.projectTargetAmount = projectTargetAmount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    public LocalDateTime getProjectApplicationDate() {
        return projectApplicationDate;
    }

    public void setProjectApplicationDate(LocalDateTime projectApplicationDate) {
        this.projectApplicationDate = projectApplicationDate;
    }
}
