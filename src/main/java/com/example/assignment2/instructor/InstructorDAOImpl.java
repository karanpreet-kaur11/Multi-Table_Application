package com.example.assignment2.instructor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Instructor instructor) {
        if (instructor.getId() == null) {
            entityManager.persist(instructor);
        } else {
            entityManager.merge(instructor);
        }
    }

    @Override
    public Instructor findById(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Instructor> findAll() {
        String jpql = "SELECT i FROM Instructor i";
        return entityManager.createQuery(jpql, Instructor.class)
                .getResultList();
    }

    @Override
    public List<Instructor> findInstructorsWithAtLeastOneCourse() {
        String jpql = "SELECT DISTINCT i FROM Instructor i JOIN i.courses c";
        return entityManager.createQuery(jpql, Instructor.class)
                .getResultList();
    }
}
