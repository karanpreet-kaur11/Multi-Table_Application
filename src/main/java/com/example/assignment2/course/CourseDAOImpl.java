package com.example.assignment2.course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
    }

    @Override
    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        String jpql = "SELECT c FROM Course c";
        return entityManager.createQuery(jpql, Course.class)
                .getResultList();
    }

    @Override
    public List<Course> findCoursesByInstructorId(Long instructorId) {
        String jpql = "SELECT c FROM Course c WHERE c.instructor.id = :instructorId";
        return entityManager.createQuery(jpql, Course.class)
                .setParameter("instructorId", instructorId)
                .getResultList();
    }
}
