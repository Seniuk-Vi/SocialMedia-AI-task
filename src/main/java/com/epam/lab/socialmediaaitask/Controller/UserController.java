package com.epam.lab.socialmediaaitask.Controller;

import com.epam.lab.socialmediaaitask.Models.User;
import com.epam.lab.socialmediaaitask.Services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    public User getUser(Long id) {
        return userService.findById(id);
    }


    public void saveOrUpdateUser(User user) {
        userService.saveOrUpdate(user);
    }


    public void deleteUser(Long id) {
        userService.delete(id);
    }

    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // Follow a user
    public boolean followUser(Long userId, Long followerId) {
        return userService.followUser(userId, followerId);
    }

}