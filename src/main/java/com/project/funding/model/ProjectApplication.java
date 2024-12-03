package com.project.funding.model;

import com.project.funding.repository.StatefulEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// 프로젝트 신청 정보를 나타내는 엔터티 클래스
@Entity
@Table(name = "project_applications") // 데이터베이스의 project_applications 테이블과 매핑
public class ProjectApplication implements StatefulEntity<ProjectApplicationState> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 자동 생성
    @Column(name = "project_application_id")
    private Long id; // 프로젝트 신청 ID (기본 키)

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 카테고리와 다대일 관계
    @JoinColumn(name = "category_id", nullable = false) // 외래 키 설정
    private Category category; // 카테고리 테이블 참조

    @Column(name = "project_name", nullable = false, length = 100) // 프로젝트 이름 컬럼
    private String projectName; // 프로젝트 이름

    @Column(name = "project_description", nullable = false, columnDefinition = "TEXT") // 프로젝트 내용 컬럼
    private String projectDescription; // 프로젝트 상세 설명

    @Column(name = "project_start_date", nullable = false) // 프로젝트 시작 날짜 컬럼
    private LocalDate projectStartDate; // 프로젝트 시작 날짜

    @Column(name = "project_end_date", nullable = false) // 프로젝트 종료 날짜 컬럼
    private LocalDate projectEndDate; // 프로젝트 종료 날짜

    @Column(name = "project_target_amount", nullable = false, precision = 10, scale = 2) // 프로젝트 목표 금액 컬럼
    private BigDecimal projectTargetAmount; // 프로젝트 목표 금액 (소수점 포함)

    @Enumerated(EnumType.STRING) // 상태를 문자열로 저장
    @Column(name = "project_application_review", nullable = false)
    private ProjectApplicationState state = ProjectApplicationState.PENDING; // 기본 상태: 승인 대기 중

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 회원과 다대일 관계
    @JoinColumn(name = "user_id", nullable = false) // 외래 키 설정
    private User user; // 프로젝트 신청자와 연관된 회원 엔터티

    // 상태를 가져오는 메서드 (StatefulEntity 인터페이스 구현)
    @Override
    public ProjectApplicationState getState() {
        return state; // 현재 프로젝트 신청 상태 반환
    }

    // 상태를 설정하는 메서드 (StatefulEntity 인터페이스 구현)
    @Override
    public void setState(ProjectApplicationState state) {
        this.state = state; // 프로젝트 신청 상태 변경
    }

    // Getter 및 Setter 추가

    public Long getId() {
        return id; // 프로젝트 신청 ID 반환
    }

    public void setId(Long id) {
        this.id = id; // 프로젝트 신청 ID 설정
    }

    public Category getCategory() {
        return category; // 카테고리 반환
    }

    public void setCategory(Category category) {
        this.category = category; // 카테고리 설정
    }

    public String getProjectName() {
        return projectName; // 프로젝트 이름 반환
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName; // 프로젝트 이름 설정
    }

    public String getProjectDescription() {
        return projectDescription; // 프로젝트 설명 반환
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription; // 프로젝트 설명 설정
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate; // 프로젝트 시작 날짜 반환
    }

    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate; // 프로젝트 시작 날짜 설정
    }

    public LocalDate getProjectEndDate() {
        return projectEndDate; // 프로젝트 종료 날짜 반환
    }

    public void setProjectEndDate(LocalDate projectEndDate) {
        this.projectEndDate = projectEndDate; // 프로젝트 종료 날짜 설정
    }

    public BigDecimal getProjectTargetAmount() {
        return projectTargetAmount; // 프로젝트 목표 금액 반환
    }

    public void setProjectTargetAmount(BigDecimal projectTargetAmount) {
        this.projectTargetAmount = projectTargetAmount; // 프로젝트 목표 금액 설정
    }

    public User getUser() {
        return user; // 프로젝트 신청자 반환
    }

    public void setUser(User user) {
        this.user = user; // 프로젝트 신청자 설정
    }
}