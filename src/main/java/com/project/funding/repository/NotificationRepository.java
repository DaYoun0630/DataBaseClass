package com.project.funding.repository;

import com.project.funding.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // 특정 사용자 ID의 알림 목록 조회
    List<Notification> findByUserUserId(String userId);
}
