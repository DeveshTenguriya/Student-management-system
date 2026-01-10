package com.example.Student.management.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequest {

    @NotNull
    @NotBlank(message = "username is required")
    private String username;
    @NotNull
    @NotBlank(message = "password id required")
    private String password;
}
