package com.example.assignment2.enrollment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnrollmentDAOImpl implements EnrollmentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Enrollment enrollment) {
        if (enrollment.getId() == null) {
            entityManager.persist(enrollment);
        } else {
            entityManager.merge(enrollment);
        }
    }

    @Override
    public List<Enrollment> findEnrollmentsByCourseId(Long courseId) {
        String jpql = "SELECT e FROM Enrollment e WHERE e.course.id = :courseId";
        return entityManager.createQuery(jpql, Enrollment.class)
                .setParameter("courseId", courseId)
                .getResultList();
    }
}
