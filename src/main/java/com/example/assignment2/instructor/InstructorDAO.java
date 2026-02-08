package com.example.assignment2.instructor;

import java.util.List;

public interface InstructorDAO {

    void save(Instructor instructor);

    Instructor findById(Long id);

    List<Instructor> findAll();

    List<Instructor> findInstructorsWithAtLeastOneCourse();
}
