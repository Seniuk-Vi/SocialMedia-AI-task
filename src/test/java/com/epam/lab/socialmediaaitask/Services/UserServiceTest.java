package com.epam.lab.socialmediaaitask.Services;

import com.epam.lab.socialmediaaitask.Models.User;
import com.epam.lab.socialmediaaitask.Repository.UserRepository;
import com.epam.lab.socialmediaaitask.Services.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;


    @Test
    void testFindById() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(user);

        User result = userService.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testSaveOrUpdate() {
        User user = new User();
        userService.saveOrUpdate(user);
        verify(userRepository, times(1)).saveOrUpdate(user);
    }

    @Test
    void testDelete() {
        userService.delete(1L);
        verify(userRepository, times(1)).delete(1L);
    }

    @Test
    void testFindAll() {
        User user = new User();
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> users = userService.findAll();
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    void testFollowUser() {
        // Create test users
        User userToFollow = spy(new User());
        userToFollow.setId(1L);
        User follower = new User();
        follower.setId(2L);
        when(userRepository.findById(1L)).thenReturn(userToFollow);
        when(userRepository.findById(2L)).thenReturn(follower);
        when(userToFollow.getFollowers()).thenReturn(new HashSet<>());

        boolean followSuccess = userService.followUser(1L, 2L);
        assertTrue(followSuccess);
        assertTrue(userToFollow.getFollowers().contains(follower));

    }
    // Additional tests for other UserService methods
}