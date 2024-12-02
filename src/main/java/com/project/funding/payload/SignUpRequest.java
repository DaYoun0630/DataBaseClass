package com.project.funding.payload;

import javax.validation.constraints.*;

public class SignUpRequest {

    @Size(max = 20) // 최대 20자 제한
    @NotBlank(message = "사용자 ID를 입력 해야 합니다")
    private String userId;


    @NotBlank
    @Size(max = 40)
    private String userName;

    @NotBlank
    @Size(min = 6, max = 30)
    private String userPassword;

    @Size(max = 40)
    @NotBlank(message = "이메일을 입력 해야 합니다")
    @Email(message = "유효한 이메일 주소를 입력 해야 합니다")
    private String userEmail;


    @NotBlank
    @Size(max = 50)
    private String userPhoneNumber;;

    @NotBlank
    private String userBirthdate; // 문자열 형식의 생년월일 ("yyyy-MM-dd")

    @Size(max = 100)
    private String userAddress;

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(String userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
