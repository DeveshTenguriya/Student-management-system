package com.example.Student.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "Student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "Student_sequence",
            sequenceName = "Student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Student_sequence"
    )
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    private long Student_id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String department;

    public Student() {
    }

    public Student(String name,
                   String email,
                   LocalDate birthDate,
                   String department) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.department = department;
    }

    public Student(String name,
                   String email,
                   LocalDate birthDate,
                   String department,
                   long Student_id) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.department = department;
        this.Student_id = Student_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + Student_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", department='" + department + '\'' +
                '}';
    }

    public long getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(long Student_id) {
        this.Student_id = Student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
