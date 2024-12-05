package com.project.funding.model;

import javax.persistence.*;

/**
 * 역할 엔터티
 * 사용자의 역할을 정의하는 엔터티로, USER, ADMIN 등의 역할을 관리합니다.
 */
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // 역할 ID

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private RoleName name; // 역할 이름 (예: ROLE_USER)

    public UserRole() {}

    public UserRole(RoleName name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
