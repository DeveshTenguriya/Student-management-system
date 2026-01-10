package com.example.Student.management.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.core.io.SegmentedStringWriter;

@Getter
@Setter
public class UserRegisterRequest {

    @NotNull(message = "username is required")
    @NotBlank
    private String username;
    @NotNull(message = "password is required")
    @NotBlank
    private String password;
}
