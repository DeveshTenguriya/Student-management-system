package com.example.Student.management.system.Services;


import com.example.Student.management.system.Repository.CourseRepository;
import com.example.Student.management.system.Repository.StudentRepository;
import com.example.Student.management.system.dto.StudentRequestDTO;
import com.example.Student.management.system.dto.StudentResponseDTO;
import com.example.Student.management.system.entity.Course;
import com.example.Student.management.system.entity.Student;
import com.example.Student.management.system.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentServices {

    private static final Logger log =
            LoggerFactory.getLogger(StudentServices.class);

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
    public Page<StudentResponseDTO> getStudent(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return studentRepository.findAll(pageable)
                .map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

   // this service is used to get the student by its id;
   public Student GetStudentByID(Long Student_id){
       return studentRepository.findById(Student_id).
               orElseThrow(()-> new ResourceNotFoundException(
                       "Student with"+Student_id+"Does not exist"));
   }


   // this service is used to create the student when post api hit
   public StudentResponseDTO CreateStudent(StudentRequestDTO dto){

       log.info("Creating student with email: {}", dto.getEmail());

        Student student= modelMapper.map(dto,Student.class);// DTO → Entity(Student Entity field name must match exactly with DTO field)

        Student saveStudent=  studentRepository.save(student);// Save to DB

        StudentResponseDTO response= modelMapper.map(saveStudent,StudentResponseDTO.class);// Entity → Response DTO

        response.setCourses(List.of());

       log.info("Student created with ID: {}", saveStudent.getStudent_id());

        return response;

   }

   // this service is to update the student
   @Transactional
   public StudentResponseDTO UpdateStudent(Long Student_id,StudentRequestDTO dto){

       log.info("Updating student with ID: {}", Student_id);


        Student student= studentRepository
                .findById(Student_id)
                .orElseThrow(()-> new ResourceNotFoundException
                        ("Student with this ID"+Student_id+"does not exist"));

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

       log.info("Student updated successfully with ID: {}", Student_id);

        return modelMapper.map(student,StudentResponseDTO.class);

   }

   // this service is used to enroll the student in teh course
   @Transactional
   public void EnrollStudentInCourse(Long Student_id,Long Course_id){
        Student student = studentRepository.findById(Student_id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
       Course course= courseRepository.findById(Course_id)
               .orElseThrow(()-> new ResourceNotFoundException("Course not found"));

       student.getCourses().add(course);
   }


   public void DeleteStudent(Long Student_id){
        Student student = studentRepository.findById(Student_id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Student not found"));

        student.getCourses().clear();
        studentRepository.delete(student);
   }

}
