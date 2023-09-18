package com.epam.lab.socialmediaaitask.Repository;

import com.epam.lab.socialmediaaitask.Models.User;

import java.util.List;

public interface UserRepository {

    User findById(Long id);

    void saveOrUpdate(User user);

    void delete(Long id);

    List<User> findAll();

}