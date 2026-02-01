package com.blogPosting.Api.controller;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.service.PostService;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController (PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<@NotNull Post> createPosts(@RequestBody CreatePostsDTO postsDTO) {
        Post newPost = postService.createPost(postsDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }
}
