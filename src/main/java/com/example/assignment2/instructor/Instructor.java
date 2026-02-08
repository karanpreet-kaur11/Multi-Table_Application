package com.example.assignment2.instructor;

import com.example.assignment2.course.Course;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // ToDo: Create a one-to-many relationship with Course
    //       Use mappedBy = "instructor"
    //       Use cascade = CascadeType.ALL
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses = new ArrayList<>();

    public Instructor() {}

    public Instructor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // ToDo: Implement helper method addCourse(Course c)
    //       This should set both sides of the relationship.
    public void addCourse(Course course) {
        courses.add(course);
        course.setInstructor(this);
    }

    // Getters and setters

    public Long getId() {
        return id;
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

    public List<Course> getCourses() {
        return courses;
    }
}