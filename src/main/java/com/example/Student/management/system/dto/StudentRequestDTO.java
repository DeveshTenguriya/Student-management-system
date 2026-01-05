package com.example.Student.management.system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter // these are lambok getters and setters
@Getter
public class StudentRequestDTO {

    @NotNull(message = "Name is required")
    private String name;

    @Email(message = "Email format was not correct")
    @NotBlank(message = "Mail is required")
    private String email;

    @NotNull(message = "Date of Birth is required")
    private LocalDate birthDate;

    @NotBlank(message = "Department is required")
    private String department;

//    What this DTO is for
//    Used in POST /students
//    Used in PUT /students/{id}
//    Represents input from client

}
