package com.project.funding.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 댓글(Comment) 정보를 나타내는 엔터티 클래스
 * 프로젝트와 사용자 간의 댓글 데이터를 관리
 */
@Entity
@Table(name = "comment") // 데이터베이스의 'comments' 테이블과 매핑
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 증가 설정
    @Column(name = "comment_id")
    private Long id; // 댓글 ID

    @Column(name = "content", nullable = false, length = 255) // 댓글 내용
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false) // 생성 시간
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // 사용자와의 연관 관계
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false) // 프로젝트와의 연관 관계
    private ProjectRegistration project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false) // 카테고리와의 연관 관계
    private Category category;

    // 기본 생성자
    public Comment() {}

    // Getter와 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProjectRegistration getProject() {
        return project;
    }

    public void setProject(ProjectRegistration project) {
        this.project = project;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
