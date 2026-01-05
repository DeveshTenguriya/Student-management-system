package com.example.Student.management.system.Services;


import com.example.Student.management.system.Repository.CourseRepository;
import com.example.Student.management.system.Repository.StudentRepository;
import com.example.Student.management.system.dto.StudentRequestDTO;
import com.example.Student.management.system.dto.StudentResponseDTO;
import com.example.Student.management.system.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentServices(StudentRepository studentRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    //this service is used to get the student when get api hit
     public List<Student> getStudent(){
       return studentRepository.findAll();
   }


   // this service is used to create the student when post api hit
   public StudentResponseDTO CreateStudent(StudentRequestDTO dto){

        Student student= modelMapper.map(dto,Student.class);// DTO → Entity(Student Entity field name must match exactly with DTO field)

        Student saveStudent=  studentRepository.save(student);// Save to DB

        StudentResponseDTO response= modelMapper.map(saveStudent,StudentResponseDTO.class);// Entity → Response DTO

        response.setCourses(List.of());

        return response;

   }

}
