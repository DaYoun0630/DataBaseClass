package com.project.funding.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.funding.model.ProjectApplication;
import com.project.funding.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectApplicationController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/current-user")
    public ResponseEntity<String> getCurrentUserId(@RequestHeader("Authorization") String token) {
        System.out.println("Received token: " + token);
        String userId = jwtTokenProvider.getUserIdFromJWT(token);
        System.out.println("Extracted userId: " + userId);
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyProject(@RequestBody ProjectApplication projectApplication) {
        try {
            System.out.println("Received project application: " + new ObjectMapper().writeValueAsString(projectApplication));
            // 요청 데이터 확인 및 처리 로직 (서비스 호출 등)
            return ResponseEntity.ok("프로젝트 신청이 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("프로젝트 신청 처리 중 오류가 발생했습니다.");
        }
    }
}
