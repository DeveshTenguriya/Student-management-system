package com.example.Student.management.system.Controller;


import com.example.Student.management.system.entity.Course;
import com.example.Student.management.system.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/project/Course")
public class CoursesController {


    @GetMapping
    public List<Course> getCourses(){

        return List.of(new Course(1L,"Computer",4),
                new Course(2L,"JAVA",4));
    };

}
