package com.project.funding.security;

import com.project.funding.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * 사용자 인증 정보
 * Spring Security에서 사용자의 인증 정보를 관리하는 클래스입니다.
 */
public class UserPrincipal implements UserDetails {

    private String userId;
    private String userName;

    @JsonIgnore
    private String userEmail;

    @JsonIgnore
    private String userPassword;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String userId, String userName,
                         String userEmail, String userPassword, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.authorities = authorities;
    }

    // User 엔터티의 단일 역할 필드를 활용하여 권한 리스트를 생성합니다.
    public static UserPrincipal create(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getUserRole().name());

        return new UserPrincipal(
                user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPassword(),
                Collections.singleton(authority) // 단일 권한으로 설정
        );
    }

    public String getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
