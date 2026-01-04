package com.example.Student.management.system.Services;


import com.example.Student.management.system.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServices {

    public List<Course> getCourse(){
        return List.of(new Course(1L,
                        "Computer",
                        4),

                new Course(2L,
                        "JAVA",
                        4));
    }

}
