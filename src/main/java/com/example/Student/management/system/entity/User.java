package com.example.Student.management.system.entity;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import javax.management.relation.Role;

public class User {

    private Long UserId;
    private  String UserName;
    private String Password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(Long userId, String userName, String password, Role role) {
        UserId = userId;
        UserName = userName;
        Password = password;
        this.role = role;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
