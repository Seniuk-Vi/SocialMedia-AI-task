package com.epam.lab.socialmediaaitask.Repository.impl;

import com.epam.lab.socialmediaaitask.Models.Like;
import com.epam.lab.socialmediaaitask.Repository.LikeRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class LikeRepositoryImpl implements LikeRepository {


    private final SessionFactory sessionFactory;
    @Override
    public Like findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Like.class, id);
        }
    }

    @Override
    public void saveOrUpdate(Like like) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(like);
            transaction.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Like like = session.get(Like.class, id);
            if (like != null) {
                session.remove(like);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Like> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Like", Like.class).list();
        }
    }

    // Other like-specific methods
}