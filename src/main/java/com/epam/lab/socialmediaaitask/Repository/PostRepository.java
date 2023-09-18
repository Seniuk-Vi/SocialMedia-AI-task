package com.epam.lab.socialmediaaitask.Repository;

import com.epam.lab.socialmediaaitask.Models.Post;

import java.util.List;

public interface PostRepository {

    Post findById(Long id);

    void saveOrUpdate(Post post);

    void delete(Long id);

    List<Post> findAll();

}