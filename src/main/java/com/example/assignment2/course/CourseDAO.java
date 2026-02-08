package com.example.assignment2.course;

import java.util.List;

public interface CourseDAO {

    void save(Course course);

    Course findById(Long id);

    List<Course> findAll();

    List<Course> findCoursesByInstructorId(Long instructorId);
}
