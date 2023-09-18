package com.epam.lab.socialmediaaitask.Services.impl;

import com.epam.lab.socialmediaaitask.Models.Post;
import com.epam.lab.socialmediaaitask.Repository.PostRepository;
import com.epam.lab.socialmediaaitask.Services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;



    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Post post) {
        postRepository.saveOrUpdate(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }



}