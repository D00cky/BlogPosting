package com.blogPosting.Api.controller;

import com.blogPosting.Api.dto.PostCreateDTO;
import com.blogPosting.Api.dto.PostResponseDTO;
import com.blogPosting.Api.service.PostService;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController (PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<@NotNull PostResponseDTO> createPosts(@RequestBody PostCreateDTO postsDTO) {
        PostResponseDTO responseDTO = postService.createPost(postsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
