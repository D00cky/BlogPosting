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

    public CreatePostsDTO createPost(@NotNull Post post) {
        if(postRepository.findByNickname(post.getNickname()).isEmpty()) {
            ResponseEntity.ok("Post Created");
        }  else {
            throw new RuntimeException("Needs to register before post");
        }
        CreatePostsDTO createPostsDTO = postMapper.mapToPostCreation(post);

        return createPostsDTO;
    }


}
