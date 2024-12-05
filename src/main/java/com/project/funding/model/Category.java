package com.project.funding.model;

import javax.persistence.*;

// 프로젝트 카테고리를 나타내는 엔터티 클래스
@Entity
@Table(name = "categories") // 데이터베이스의 categories 테이블과 매핑
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 자동 생성
    @Column(name = "category_id")
    private Long id; // 카테고리 ID (기본 키)

    @Column(name = "category_name", nullable = false, length = 100, unique = true) // 카테고리 이름
    private String categoryName; // 카테고리 이름

    // Getter 및 Setter
    public Long getId() {
        return id; // 카테고리 ID 반환
    }

    public void setId(Long id) {
        this.id = id; // 카테고리 ID 설정
    }

    public String getCategoryName() {
        return categoryName; // 카테고리 이름 반환
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName; // 카테고리 이름 설정
    }
}
