package com.example.assignment2.enrollment;

import java.util.List;

public interface EnrollmentDAO {

    void save(Enrollment enrollment);

    List<Enrollment> findEnrollmentsByCourseId(Long courseId);
}
