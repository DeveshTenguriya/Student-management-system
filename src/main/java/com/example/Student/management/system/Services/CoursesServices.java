package com.example.Student.management.system.Services;


import com.example.Student.management.system.Repository.CourseRepository;
import com.example.Student.management.system.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServices {

    private final CourseRepository courseRepository;

    @Autowired
    public CoursesServices(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }



    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    public Course CreateCourse(Course course){
       return courseRepository.save(course);
    }

}
