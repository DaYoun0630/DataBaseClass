package com.project.funding.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

	@Id
	@NotBlank // 사용자로부터 입력받아야 함
	@Column(name = "user_id", nullable = false, unique = true)
	private String userId; // 사용자 ID

	@NotBlank
	@Size(max = 50)
	@Column(name = "user_name", nullable = false)
	private String userName; // 사용자 이름

	@NotBlank
	@Email
	@Column(name = "user_email", nullable = false, unique = true)
	private String userEmail; // 사용자 이메일

	@NotBlank
	@Size(max = 100)
	@Column(name = "user_password", nullable = false)
	private String userPassword; // 비밀번호

	@Column(name = "user_birthdate")
	private LocalDate userBirthdate; // 생년월일

	@Size(max = 15)
	@Column(name = "user_phone_number")
	private String userPhoneNumber; // 전화번호

	@Size(max = 100)
	@Column(name = "user_address")
	private String userAddress; // 주소

	@CreationTimestamp // Hibernate가 자동으로 현재 시간 설정
	@Column(updatable = false) // 생성 이후 변경 불가능
	private LocalDateTime userRegistrationDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", nullable = false)
	private RoleName userRole = RoleName.USER; // 기본 역할: USER

	// 역할 변경 메서드
	public void updateRoleToSponsor() {
		this.userRole = RoleName.SPONSOR; // 후원자로 전환
	}

	public void updateRoleToCreator() {
		this.userRole = RoleName.CREATOR; // 창작자로 전환
	}

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDate getUserBirthdate() {
		return userBirthdate;
	}

	public void setUserBirthdate(LocalDate userBirthdate) {
		this.userBirthdate = userBirthdate;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public RoleName getUserRole() {
		return userRole;
	}

	public void setUserRole(RoleName userRole) {
		this.userRole = userRole;
	}

	public LocalDateTime getUserRegistrationDate() {
		return userRegistrationDate;
	}

	public void setUserRegistrationDate(LocalDateTime userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}
}
