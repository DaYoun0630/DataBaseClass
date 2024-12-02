package com.project.funding.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @Column(nullable = false, unique = true) // 고유 ID
    private Long id; // 사용자 입력으로 받는 ID

    @ManyToOne(fetch = FetchType.LAZY) // 사용자와 다대일 관계
    @JoinColumn(name = "user_id", nullable = false) // 외래 키 설정
    private User user;

    @Column(nullable = false)
    private Boolean isRead = false; // 읽음 여부

    @Column(nullable = false)
    private String message; // 알림 메시지

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // 생성 시간

    // Getter 및 Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
