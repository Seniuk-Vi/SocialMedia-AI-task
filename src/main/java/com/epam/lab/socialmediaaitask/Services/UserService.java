package com.epam.lab.socialmediaaitask.Services;

import com.epam.lab.socialmediaaitask.Models.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    void saveOrUpdate(User user);

    void delete(Long id);

    List<User> findAll();

    // Other user-specific methods, such as login, registration, and followUser
    boolean followUser(Long userId, Long followerId);
}