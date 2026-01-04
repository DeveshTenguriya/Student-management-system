package com.example.Student.management.system;

import com.example.Student.management.system.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/project/student")
@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
        System.out.println("devesh tenguriya");
	}

    @GetMapping
   public List<Student> getStudents(){

       return List.of(new Student("Devesh Tenguriya","devesh@gmail.com",LocalDate.of(2004,10,10),"Information technology"),
               new Student("Naruto","naruto@gmail.com",LocalDate.of(2005,10,10),"Hokage"));
   };
}
