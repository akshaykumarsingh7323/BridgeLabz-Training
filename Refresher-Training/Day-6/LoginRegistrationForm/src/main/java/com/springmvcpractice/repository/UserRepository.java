package com.springmvcpractice.repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.springmvcpractice.entity.User;

@Repository

public class UserRepository {

    @PersistenceContext

    private EntityManager entityManager;


    // Save user

    @Transactional

    public void save(User user) {

        entityManager.persist(user);
    }


    // Find user by email

    public User findByEmail(String email) {

        try {

            return entityManager.createQuery(
                    "SELECT u FROM User u " +
                    "WHERE u.email = :email",
                    User.class
                )

                .setParameter(
                    "email",
                    email
                )

                .getSingleResult();

        } catch (Exception e) {

            return null;
        }
    }


    // Find user by ID

    public User findById(int id) {

        return entityManager.find(
            User.class,
            id
        );
    }


    // Update user

    @Transactional

    public void update(User user) {

        entityManager.merge(user);
    }


    // Delete user

    @Transactional

    public void delete(int id) {

        User user =
            entityManager.find(
                User.class,
                id
            );

        if (user != null) {

            entityManager.remove(user);
        }
    }
}