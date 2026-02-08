package com.example.assignment2.course;

import com.example.assignment2.instructor.Instructor;
import com.example.assignment2.instructor.InstructorDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseDAO courseDAO;
    private final InstructorDAO instructorDAO;

    public CourseController(CourseDAO courseDAO, InstructorDAO instructorDAO) {
        this.courseDAO = courseDAO;
        this.instructorDAO = instructorDAO;
    }

    // Add a course and assign it to an instructor
    @PostMapping("/instructor/{instructorId}")
    public void addCourseToInstructor(
            @PathVariable Long instructorId,
            @RequestBody Course course) {

        Instructor instructor = instructorDAO.findById(instructorId);
        if (instructor == null) {
            throw new RuntimeException("Instructor not found with id " + instructorId);
        }

        // Keep both sides of the relationship in sync
        instructor.addCourse(course);

        // CascadeType.ALL saves the course when instructor is saved
        instructorDAO.save(instructor);
    }

    // List all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseDAO.findAll();
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(@PathVariable Long instructorId) {
        return courseDAO.findCoursesByInstructorId(instructorId);
    }
}
