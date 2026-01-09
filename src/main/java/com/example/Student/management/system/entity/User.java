package com.example.Student.management.system.entity;


import jakarta.persistence.*;


import com.example.Student.management.system.entity.Role;



@Entity(name = "User")
@Table
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence"
            , sequenceName = "user_sequence"
            , allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "user_sequence")
    private Long UserId;

    @Column(nullable = false, unique = true)
    private  String username;

    @Column(nullable = false)
    private String Password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(Long userId, String username, String password, Role role) {
        UserId = userId;
        username = username;
        Password = password;
        this.role = role;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getusername() {
        return username;
    }

    public void setUserName(String username) {
        username = username;
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
