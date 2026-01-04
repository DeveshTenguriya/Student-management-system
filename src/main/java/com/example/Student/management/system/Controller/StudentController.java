package com.example.Student.management.system.Controller;


import com.example.Student.management.system.Services.StudentServices;
import com.example.Student.management.system.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/project/student")
public class StudentController {

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    public StudentServices  studentServices;

    @GetMapping
    public List<Student> getStudents(){

        return List.of(new Student("Devesh Tenguriya","devesh@gmail.com", LocalDate.of(2004,10,10),"Information technology",1L),
                new Student("Naruto Uzumaki","naruto@gmail.com",LocalDate.of(2005,10,10),"Hokage",2L));
    };



}
