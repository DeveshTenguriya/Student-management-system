package com.example.Student.management.system.Services;


import com.example.Student.management.system.Repository.CourseRepository;
import com.example.Student.management.system.Repository.StudentRepository;
import com.example.Student.management.system.dto.StudentRequestDTO;
import com.example.Student.management.system.dto.StudentResponseDTO;
import com.example.Student.management.system.entity.Course;
import com.example.Student.management.system.entity.Student;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

   // this service is used to get the student by its id;
   public Student GetStudentByID(Long Student_id){
       return studentRepository.findById(Student_id).
               orElseThrow(()-> new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "Student with"+Student_id+"Does not exist"));
   }


   // this service is used to create the student when post api hit
   public StudentResponseDTO CreateStudent(StudentRequestDTO dto){

        Student student= modelMapper.map(dto,Student.class);// DTO → Entity(Student Entity field name must match exactly with DTO field)

        Student saveStudent=  studentRepository.save(student);// Save to DB

        StudentResponseDTO response= modelMapper.map(saveStudent,StudentResponseDTO.class);// Entity → Response DTO

        response.setCourses(List.of());

        return response;

   }

   @Transactional
   public StudentResponseDTO UpdateStudent(Long Student_id,StudentRequestDTO dto){
        Student student= studentRepository
                .findById(Student_id)
                .orElseThrow(()-> new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Student with this ID"+Student_id+"does not exist"));

        if (dto.getName()!=null &&
                !dto.getName().isEmpty() &&
                !Objects.equals(student.getName(),dto.getName())){
            // in place of this dto.getEmail().length()>0 we can use this !dto.getEmail().isEmpty() they both are same
            student.setName(dto.getName());
        }

        if (dto.getEmail()!=null &&
                !dto.getEmail().isEmpty() &&
                !Objects.equals(student.getEmail(),dto.getEmail())){

            studentRepository.findStudentByEmail(dto.getEmail())
                    .ifPresent(s -> {
                        throw new ResponseStatusException(
                                HttpStatus.CONFLICT,
                                "Email already exists");});

            student.setEmail(dto.getEmail());
        }

        if (dto.getDepartment()!=null &&
                !dto.getDepartment().isEmpty() &&
                !Objects.equals(student.getDepartment(),dto.getDepartment())){
            student.setDepartment(dto.getDepartment());
        }

        if (dto.getBirthDate()!=null &&
                !Objects.equals(student.getBirthDate(),dto.getBirthDate())){
            student.setBirthDate(dto.getBirthDate());
        }

        return modelMapper.map(student,StudentResponseDTO.class);

   }

   // this service is used to enroll the student in teh course
   @Transactional
   public void EnrollStudentInCourse(Long Student_id,Long Course_id){
        Student student = studentRepository.findById(Student_id)
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND,"Student not found"));
       Course course= courseRepository.findById(Course_id)
               .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found"));

       student.getCourses().add(course);
   }

}
