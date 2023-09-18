package com.epam.lab.socialmediaaitask.Services;

import com.epam.lab.socialmediaaitask.Models.Like;

import java.util.List;

public interface LikeService {

    Like findById(Long id);

    void saveOrUpdate(Like like);

    void delete(Long id);

    List<Like> findAll();


}