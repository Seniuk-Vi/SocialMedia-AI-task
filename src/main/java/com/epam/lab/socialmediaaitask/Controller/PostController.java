package com.epam.lab.socialmediaaitask.Controller;

import com.epam.lab.socialmediaaitask.Models.Post;
import com.epam.lab.socialmediaaitask.Services.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor

public class PostController {

    private final PostService postService;



    // Find post by id
    public Post getPost(Long id) {
        log.info("Getting post with id: {}", id);
        Post post = postService.findById(id);
        if (post == null) {
            log.warn("Post not found for id: {}", id);
        }
        return post;
    }

    // Create or update a post
    public void saveOrUpdatePost(Post post) {
        log.info("Saving or updating post: {}", post);
        postService.saveOrUpdate(post);
    }

    // Delete post
    public void deletePost(Long id) {
        log.info("Deleting post with id: {}", id);
        postService.delete(id);
    }

    // Get all posts
    public List<Post> getAllPosts() {
        log.info("Getting all posts");
        return postService.findAll();
    }

}