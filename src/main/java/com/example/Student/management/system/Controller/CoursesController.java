package com.example.Student.management.system.Controller;


import com.example.Student.management.system.Services.CoursesServices;
import com.example.Student.management.system.entity.Course;
import com.example.Student.management.system.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/project/course")
public class CoursesController {

    private final CoursesServices coursesServices;

    @Autowired
    public CoursesController(CoursesServices coursesServices) {
        this.coursesServices = coursesServices;
    }


    @GetMapping
    public List<Course> getCourses(){
        return  coursesServices.getCourse();
    };

}
