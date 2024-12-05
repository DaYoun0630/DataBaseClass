package com.project.funding.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 프로젝트 등록 정보를 나타내는 엔터티 클래스
 */
@Entity // JPA 엔터티임을 선언
@Table(name = "project_registrations") // 데이터베이스의 'project_registrations' 테이블과 매핑

public class ProjectRegistration {

    @Id // 기본 키(primary key)로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID를 자동 생성 (Auto Increment)
    @Column(name = "project_id") // 데이터베이스 테이블의 'project_id' 컬럼과 매핑
    private Long id; // 프로젝트 ID

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 카테고리와 다대일 관계 설정
    @JoinColumn(name = "category_id", nullable = false) // 'category_id' 컬럼과 연결 (외래 키)
    private Category category; // 프로젝트가 속한 카테고리 정보

    @OneToOne(fetch = FetchType.LAZY, optional = false) // 프로젝트 신청과 일대일 관계 설정
    @JoinColumn(name = "project_application_id", nullable = false) // 'project_application_id' 컬럼과 연결 (외래 키)
    private ProjectApplication projectApplication; // 프로젝트 신청 정보

    @Column(name = "created_at", nullable = false, updatable = false) // 'created_at' 컬럼과 매핑, 수정 불가
    private LocalDateTime createdAt = LocalDateTime.now(); // 프로젝트 등록 날짜 (현재 시간 기본값)

    @Column(name = "goal_amount", nullable = false, precision = 10, scale = 2) // 'goal_amount' 컬럼과 매핑
    private BigDecimal goalAmount; // 프로젝트 목표 금액

    /**
     * 기본 생성자
     * JPA 요구 사항에 따라 기본 생성자가 필요
     */
    public ProjectRegistration() {}

    /**
     * Getter 및 Setter 메서드
     * 캡슐화를 유지하면서 필드 접근을 가능하게 함
     */

    public Long getId() {
        return id; // 프로젝트 ID 반환
    }

    public void setId(Long id) {
        this.id = id; // 프로젝트 ID 설정
    }

    public Category getCategory() {
        return category; // 프로젝트 카테고리 반환
    }

    public void setCategory(Category category) {
        this.category = category; // 프로젝트 카테고리 설정
    }

    public ProjectApplication getProjectApplication() {
        return projectApplication; // 프로젝트 신청 정보 반환
    }

    public void setProjectApplication(ProjectApplication projectApplication) {
        this.projectApplication = projectApplication; // 프로젝트 신청 정보 설정
    }

    public LocalDateTime getCreatedAt() {
        return createdAt; // 생성 날짜 반환
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt; // 생성 날짜 설정
    }

    public BigDecimal getGoalAmount() {
        return goalAmount; // 목표 금액 반환
    }

    public void setGoalAmount(BigDecimal goalAmount) {
        this.goalAmount = goalAmount; // 목표 금액 설정
    }
}
