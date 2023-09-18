package com.epam.lab.socialmediaaitask.Repository;

import com.epam.lab.socialmediaaitask.Models.Like;

import java.util.List;

public interface LikeRepository {

    Like findById(Long id);

    void saveOrUpdate(Like like);

    void delete(Long id);

    List<Like> findAll();

}