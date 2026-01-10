package com.example.Student.management.system.entity;


import jakarta.persistence.*;


import com.example.Student.management.system.entity.Role;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "User")
@Table
@Getter
@Setter
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
        this.username = username;
        Password = password;
        this.role = role;
    }
}
