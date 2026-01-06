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


    // this method is to get the student by its id
    @GetMapping(path = {"/{Student_id}"})
    public Student getStudentById(@PathVariable Long Student_id){
       return studentServices.GetStudentByID(Student_id);
    }

    // this method is for creating the student
    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody @Valid StudentRequestDTO dto){
        return  studentServices.CreateStudent(dto);

    }

    //this is for the enrollment of student in the course
    @PostMapping(path = {"/{Student_id}/course/{Course_id}"})
    public void enrollStudent(@PathVariable Long Student_id,@PathVariable Long Course_id){
         studentServices.EnrollStudentInCourse(Student_id, Course_id);
    }

    //this mapping is to update the student
    @PutMapping(path = {"/{Student_id}"})
    public StudentResponseDTO updateStudent(@PathVariable Long Student_id,@RequestBody @Valid StudentRequestDTO dto){
       return studentServices.UpdateStudent(Student_id,dto);
    }

    @DeleteMapping(path = {"/{Student_id}"})
    public void deleteStudent(@PathVariable Long Student_id){
        studentServices.DeleteStudent(Student_id);
    }

}
