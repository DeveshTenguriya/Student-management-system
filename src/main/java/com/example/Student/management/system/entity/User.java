package com.example.Student.management.system.entity;


import jakarta.persistence.*;


import com.example.Student.management.system.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "User")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
