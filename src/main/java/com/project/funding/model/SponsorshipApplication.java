package com.project.funding.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 후원 신청(Sponsorship Application) 정보를 나타내는 엔터티 클래스
 * 사용자가 특정 프로젝트에 후원 신청을 할 때의 데이터를 관리
 */
@Entity
@Table(name = "sponsorship_applications")
public class SponsorshipApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sponsorship_application_id")
    private Long id; // 후원 신청 ID

    @ManyToOne
    @JoinColumn(name = "sponsorship_id", nullable = false, unique = true) //외래키 설정
    private SponsorshipManagement sponsorshipid; // 후원 ID

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectRegistration project; // 후원할 프로젝트

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 후원 신청을 한 사용자

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount; // 후원 금액

    @Column(name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now(); // 후원 신청 날짜

    @Column(name = "method", nullable = false, length = 50)
    private String method; // 결제 방식 (예: 카드, 계좌이체 등)

    @Column(name = "details", columnDefinition = "TEXT")
    private String details; // 후원 관련 추가 세부 사항 (선택적 필드)

    // 기본 생성자
    public SponsorshipApplication() {}

    // Getter 및 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SponsorshipManagement getSponsorshipid() {
        return sponsorshipid;
    }

    public void setSponsorshipid(SponsorshipManagement sponsorshipid) {
        this.sponsorshipid = sponsorshipid;
    }

    public ProjectRegistration getProject() {
        return project;
    }

    public void setProject(ProjectRegistration project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}
