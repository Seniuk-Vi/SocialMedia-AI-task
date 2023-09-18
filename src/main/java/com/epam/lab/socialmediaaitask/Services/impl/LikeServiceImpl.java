package com.epam.lab.socialmediaaitask.Services.impl;

import com.epam.lab.socialmediaaitask.Models.Like;
import com.epam.lab.socialmediaaitask.Repository.LikeRepository;
import com.epam.lab.socialmediaaitask.Repository.PostRepository;
import com.epam.lab.socialmediaaitask.Repository.UserRepository;
import com.epam.lab.socialmediaaitask.Services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public Like findById(Long id) {
        return likeRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Like like) {
        likeRepository.saveOrUpdate(like);
    }

    @Override
    public void delete(Long id) {
        likeRepository.delete(id);
    }

    @Override
    public List<Like> findAll() {
        return likeRepository.findAll();
    }



}