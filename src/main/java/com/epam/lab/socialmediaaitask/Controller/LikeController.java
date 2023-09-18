package com.epam.lab.socialmediaaitask.Controller;

import com.epam.lab.socialmediaaitask.Models.Like;
import com.epam.lab.socialmediaaitask.Services.LikeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class LikeController {

    private final LikeService likeService;



    // Find like by id
    public Like getLike(Long id) {
        log.info("Getting like with id: {}", id);
        Like like = likeService.findById(id);
        if (like == null) {
            log.warn("Like not found for id: {}", id);
        }
        return like;
    }

    // Create or update a like
    public void saveOrUpdateLike(Like like) {
        log.info("Saving or updating like: {}", like);
        likeService.saveOrUpdate(like);
    }

    // Delete like
    public void deleteLike(Long id) {
        log.info("Deleting like with id: {}", id);
        likeService.delete(id);
    }

    // Get all likes
    public List<Like> getAllLikes() {
        log.info("Getting all likes");
        return likeService.findAll();
    }


}