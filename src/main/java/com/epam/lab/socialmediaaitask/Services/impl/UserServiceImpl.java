package com.epam.lab.socialmediaaitask.Services.impl;

import com.epam.lab.socialmediaaitask.Models.User;
import com.epam.lab.socialmediaaitask.Repository.UserRepository;
import com.epam.lab.socialmediaaitask.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.saveOrUpdate(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean followUser(Long userId, Long followerId) {
        User user = userRepository.findById(userId);
        User follower = userRepository.findById(followerId);

        if (user != null && follower != null && !user.getFollowers().contains(follower)) {
            user.getFollowers().add(follower);
            userRepository.saveOrUpdate(user);
            return true;
        }

        return false;
    }

    // Other user-specific methods implementation
}