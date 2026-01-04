package com.example.Student.management.system.Controller;


import com.example.Student.management.system.Services.StudentServices;
import com.example.Student.management.system.entity.Student;
import org.hibernate.boot.internal.Abstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/project/student")
public class StudentController {

    private final StudentServices  studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<Student> getStudents(){
        return  studentServices.getStudent();
    };

}
