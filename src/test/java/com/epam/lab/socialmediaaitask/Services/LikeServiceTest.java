package com.epam.lab.socialmediaaitask.Services;

import com.epam.lab.socialmediaaitask.Models.Like;
import com.epam.lab.socialmediaaitask.Repository.LikeRepository;
import com.epam.lab.socialmediaaitask.Services.impl.LikeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LikeServiceTest {
    @InjectMocks
    private LikeServiceImpl likeService;
    @Mock
    private LikeRepository likeRepository;


    @Test
    void testFindById() {
        Like like = new Like();
        like.setId(1L);
        when(likeRepository.findById(1L)).thenReturn(like);

        Like result = likeService.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testSaveOrUpdate() {
        Like like = new Like();
        likeService.saveOrUpdate(like);
        verify(likeRepository, times(1)).saveOrUpdate(like);
    }

    @Test
    void testDelete() {
        likeService.delete(1L);
        verify(likeRepository, times(1)).delete(1L);
    }

    @Test
    void testFindAll() {
        Like like = new Like();
        when(likeRepository.findAll()).thenReturn(Collections.singletonList(like));

        List<Like> likes = likeService.findAll();
        assertNotNull(likes);
        assertEquals(1, likes.size());
    }

    // Additional tests for other LikeService methods
}