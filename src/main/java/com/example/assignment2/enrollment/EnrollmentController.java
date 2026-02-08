package com.example.assignment2.enrollment;

import com.example.assignment2.course.Course;
import com.example.assignment2.course.CourseDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentDAO enrollmentDAO;
    private final CourseDAO courseDAO;

    public EnrollmentController(EnrollmentDAO enrollmentDAO, CourseDAO courseDAO) {
        this.enrollmentDAO = enrollmentDAO;
        this.courseDAO = courseDAO;
    }

    // Enroll a student in a course
    @PostMapping("/course/{courseId}")
    public void enrollStudent(
            @PathVariable Long courseId,
            @RequestBody Enrollment enrollment) {

        Course course = courseDAO.findById(courseId);
        if (course == null) {
            throw new RuntimeException("Course not found with id " + courseId);
        }

        enrollment.setCourse(course);
        enrollmentDAO.save(enrollment);
    }

    // REQUIRED (Assignment): list enrollments by course
    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentDAO.findEnrollmentsByCourseId(courseId);
    }
}
