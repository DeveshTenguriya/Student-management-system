package com.example.Student.management.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.core.io.SegmentedStringWriter;

@Getter
@Setter
public class UserRegisterRequest {

    @NotNull(message = "username is required")
    private String username;
    @NotNull(message = "password is required")
    private String Password;
}
