package com.example.Student.management.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Courses")
public class Course {

    @Id
    private long Course_id;
    private String courseName;
    private int Credits;

    public Course() {
    }

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
