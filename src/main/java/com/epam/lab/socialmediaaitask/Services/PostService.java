package com.epam.lab.socialmediaaitask.Services;

import com.epam.lab.socialmediaaitask.Models.Post;

import java.util.List;

public interface PostService {

    Post findById(Long id);

    void saveOrUpdate(Post post);

    void delete(Long id);

    List<Post> findAll();

    // Other post-specific methods, such as getPostsByUser
}