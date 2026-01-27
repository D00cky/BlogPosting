package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.dto.mapper.PostMapper;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.repository.PostRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    public PostService(PostMapper postMapper, PostRepository postRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
    }

    public CreatePostsDTO createPost(@NotNull Post post) {
        // checks if the user exists in the database
        if(postRepository.findByEmail(post.getUsers().getEmail()).isEmpty()) {
            ResponseEntity.ok("Post Created");
        }  else {
            throw new RuntimeException("Needs to register before post");
        }
        CreatePostsDTO createPostsDTO = postMapper.mapToPostCreation(post);

        return createPostsDTO;
        // if not, tell the user that he needs to register before post
    }


}
