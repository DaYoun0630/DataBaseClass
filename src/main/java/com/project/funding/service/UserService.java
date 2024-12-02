package com.project.funding.service;

import com.project.funding.model.RoleName;
import com.project.funding.model.User;
import com.project.funding.model.UserRole;
import com.project.funding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void updateUserRoleToSponsor(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다: " + userId));
        user.updateRoleToSponsor(); // 역할을 SPONSOR로 전환
        userRepository.save(user);
    }

    public void updateUserRoleToCreator(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다: " + userId));
        user.updateRoleToCreator(); // 역할을 CREATOR로 전환
        userRepository.save(user);
    }
}


