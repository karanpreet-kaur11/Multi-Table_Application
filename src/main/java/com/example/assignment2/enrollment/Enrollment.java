package com.example.assignment2.enrollment;

import com.example.assignment2.course.Course;
import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    // ToDo: Create many-to-one relationship to Course
    //       Use @JoinColumn(name = "course_id")
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment() {}

    public Enrollment(String studentName) {
        this.studentName = studentName;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}