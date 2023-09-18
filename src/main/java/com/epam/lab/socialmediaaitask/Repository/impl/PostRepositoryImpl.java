package com.epam.lab.socialmediaaitask.Repository.impl;

import com.epam.lab.socialmediaaitask.Models.Post;
import com.epam.lab.socialmediaaitask.Repository.PostRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final SessionFactory sessionFactory;


    @Override
    public Post findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Post.class, id);
        }
    }

    @Override
    public void saveOrUpdate(Post post) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(post);
            transaction.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Post post = session.get(Post.class, id);
            if (post != null) {
                session.remove(post);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Post> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Post", Post.class).list();
        }
    }

    // Other post-specific methods
}