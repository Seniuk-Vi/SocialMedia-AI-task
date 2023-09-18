package com.epam.lab.socialmediaaitask.Services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.epam.lab.socialmediaaitask.Models.Post;
import com.epam.lab.socialmediaaitask.Repository.PostRepository;
import com.epam.lab.socialmediaaitask.Services.impl.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @InjectMocks
    private PostServiceImpl postService;
    @Mock
    private PostRepository postRepository;



    @Test
    public void testFindById() {
        Post post = new Post();
        post.setId(1L);
        when(postRepository.findById(1L)).thenReturn(post);

        Post result = postService.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testSaveOrUpdate() {
        Post post = new Post();
        postService.saveOrUpdate(post);
        verify(postRepository, times(1)).saveOrUpdate(post);
    }

    @Test
    public void testDelete() {
        postService.delete(1L);
        verify(postRepository, times(1)).delete(1L);
    }

    @Test
    public void testFindAll() {
        Post post = new Post();
        when(postRepository.findAll()).thenReturn(Collections.singletonList(post));

        List<Post> posts = postService.findAll();
        assertNotNull(posts);
        assertEquals(1, posts.size());
    }

}