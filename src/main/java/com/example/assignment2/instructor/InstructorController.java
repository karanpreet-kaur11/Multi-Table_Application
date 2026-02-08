package com.example.assignment2.instructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorDAO instructorDAO;

    public InstructorController(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    // Add instructor
    @PostMapping
    public void addInstructor(@RequestBody Instructor instructor) {
        instructorDAO.save(instructor);
    }

    // List all instructors
    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorDAO.findAll();
    }

    @GetMapping("/with-courses")
    public List<Instructor> getInstructorsWithCourses() {
        return instructorDAO.findInstructorsWithAtLeastOneCourse();
    }
}
