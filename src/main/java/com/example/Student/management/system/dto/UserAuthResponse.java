package com.example.Student.management.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserAuthResponse {
    private String token;
    private String tokenType = "Bearer";

    public UserAuthResponse(String token) {
        this.token = token;
    }
}


