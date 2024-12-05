package com.project.funding.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String userId; // 사용자 ID

    @NotBlank
    private String userPassword; // 사용자 비밀번호

    // 사용자 ID Getter
    public String getUserId() {
        return userId;
    }

    // 사용자 ID Setter
    public void setUserId(String userId) {
        this.userId = userId;
    }

    // 사용자 비밀번호 Getter
    public String getUserPassword() {
        return userPassword;
    }

    // 사용자 비밀번호 Setter
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
