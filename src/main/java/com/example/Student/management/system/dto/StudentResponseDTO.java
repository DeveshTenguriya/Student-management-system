package com.example.Student.management.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter // these are lambok getters and setters
@Getter
public class StudentResponseDTO {

    private Long Student_id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String department;
    private List<String> Courses;


}
