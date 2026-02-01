package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.dto.mapper.PostMapper;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
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

    public Post createPost(@NotNull CreatePostsDTO postsDTO) {
        // check if the user exists in the Users table
            if(postRepository.findUserById(postsDTO.user_id()).isEmpty()) {
                Post CreatePost = postMapper.mapToPostCreation(postsDTO);
                Post SavePost = postRepository.save(CreatePost);
                ResponseEntity.ok("Post created");
            }
        return postMapper.mapToPostCreation(postsDTO);
        }
    }
