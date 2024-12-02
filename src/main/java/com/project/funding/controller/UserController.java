package com.project.funding.controller;

import com.project.funding.model.User;
import com.project.funding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PatchMapping("/{userId}/role/sponsor")
    public ResponseEntity<Void> updateUserRoleToSponsor(@PathVariable String userId) {
        userService.updateUserRoleToSponsor(userId);
        return ResponseEntity.noContent().build(); // 성공 시 빈 응답
    }

    @PatchMapping("/{userId}/role/creator")
    public ResponseEntity<Void> updateUserRoleToCreator(@PathVariable String userId) {
        userService.updateUserRoleToCreator(userId);
        return ResponseEntity.noContent().build(); // 성공 시 빈 응답
    }
}

