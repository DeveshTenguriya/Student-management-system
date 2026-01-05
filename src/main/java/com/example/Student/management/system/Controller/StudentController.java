package com.example.Student.management.system.Controller;


import com.example.Student.management.system.Services.StudentServices;
import com.example.Student.management.system.dto.StudentRequestDTO;
import com.example.Student.management.system.dto.StudentResponseDTO;
import com.example.Student.management.system.entity.Student;
import jakarta.validation.Valid;
import org.hibernate.boot.internal.Abstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody @Valid StudentRequestDTO dto){
        return  studentServices.CreateStudent(dto);

    }

    @PostMapping(path = {"/{Student_id}/course/{Course_id}"})
    public void enrollStudent(@PathVariable Long Student_id,@PathVariable Long Course_id){
         studentServices.EnrollStudentInCourse(Student_id, Course_id);
    }


}
