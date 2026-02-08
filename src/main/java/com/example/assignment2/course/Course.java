package com.example.assignment2.course;

import com.example.assignment2.instructor.Instructor;
import com.example.assignment2.enrollment.Enrollment;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int credits;

    // ToDo: Create a many-to-one relationship to Instructor
    //       Use @JoinColumn(name = "instructor_id")
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // ToDo: Add one-to-many relationship with Enrollment
    //       Use mappedBy = "course"
    //       Use cascade = CascadeType.ALL
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {}

    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}