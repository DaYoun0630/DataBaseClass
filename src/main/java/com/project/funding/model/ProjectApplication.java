package com.project.funding.model;

import com.project.funding.repository.StatefulEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "projectapplication")
public class ProjectApplication implements StatefulEntity<ProjectApplicationState> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_application_id")
    private Long projectApplicationId;

    @Column(name = "project_name", nullable = false, length = 100)
    private String projectName;

    @Column(name = "project_description", nullable = false, columnDefinition = "TEXT")
    private String projectDescription;

    @Column(name = "project_start_date", nullable = false)
    private LocalDate projectStartDate;

    @Column(name = "project_end_date", nullable = false)
    private LocalDate projectEndDate;

    @Column(name = "project_target_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal projectTargetAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_application_review", nullable = false)
    private ProjectApplicationState state = ProjectApplicationState.PENDING;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "project_application_date", nullable = false)
    private LocalDate projectApplicationDate;

    // StatefulEntity Interface Implementation
    @Override
    public ProjectApplicationState getState() {
        return state;
    }

    @Override
    public void setState(ProjectApplicationState state) {
        this.state = state;
    }

    // Getters and Setters
    public Long getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(Long projectApplicationId) {
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getProjectApplicationDate() {
        return projectApplicationDate;
    }

    public void setProjectApplicationDate(LocalDate projectApplicationDate) {
        this.projectApplicationDate = projectApplicationDate;
    }
}
