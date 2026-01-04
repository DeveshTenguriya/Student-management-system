package com.example.Student.management.system.Services;


import com.example.Student.management.system.entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class StudentServices {

 public List<Student> getStudent(){
     return List.of(new Student("Devesh Tenguriya",
                     "devesh@gmail.com",
                     LocalDate.of(2004,10,10),
                     "Information technology",
                     1L),

             new Student("Naruto Uzumaki",
                     "naruto@gmail.com",
                     LocalDate.of(2005,10,10),
                     "Hokage",
                     2L));
 }

}
