package com.example.Student.management.system.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Courses")
@Table(name = "Courses")
public class Course {

    @Id
    @SequenceGenerator(
            name = "Course-sequence",
            sequenceName = "Course-sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Course-sequence"
    )
    @Column(
            name = "courseId",
            unique = true,
            nullable = false
    )
    private long Course_id;

    @Column(name = "coursename", nullable = false)
    private String courseName;

    @Column(name = "credits",nullable = false)
    private int Credits;

    public Course() {
    }

    //many-to-many relation with the student entity
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course(String courseName, int credits) {
        this.courseName = courseName;
        Credits = credits;
    }

    public Course(long course_id, String courseName, int credits) {
        Course_id = course_id;
        this.courseName = courseName;
        Credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Course_id=" + Course_id +
                ", courseName='" + courseName + '\'' +
                ", Credits=" + Credits +
                '}';
    }

    public long getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(long course_id) {
        Course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }
}
