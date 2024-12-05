package com.project.funding.model; // 프로젝트의 모델 클래스가 위치한 패키지

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 후원 관리(Sponsorship Management) 정보를 나타내는 엔터티 클래스
 * 프로젝트와 관련된 후원 데이터를 관리
 */
@Entity
@Table(name = "sponsorship_managements") // 데이터베이스의 'sponsorship_managements' 테이블과 매핑
public class SponsorshipManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sponsorship_id")
    private Long sponsorshipid; // 후원 ID (Primary Key)

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectRegistration project; // 후원과 연결된 프로젝트

    @Column(name = "rt_donation_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal realTimeDonationAmount; // 실시간 총 후원 금액

    // 기본 생성자
    public SponsorshipManagement() {}

    // Getter 및 Setter
    public Long getSponsorshipid() {
        return sponsorshipid;
    }

    public void setSponsorshipId(Long sponsorshipid) {
        this.sponsorshipid = sponsorshipid;
    }

    public ProjectRegistration getProject() {
        return project;
    }

    public void setProject(ProjectRegistration project) {
        this.project = project;
    }

    public BigDecimal getRealTimeDonationAmount() {
        return realTimeDonationAmount;
    }

    public void setRealTimeDonationAmount(BigDecimal realTimeDonationAmount) {
        this.realTimeDonationAmount = realTimeDonationAmount;
    }
}
