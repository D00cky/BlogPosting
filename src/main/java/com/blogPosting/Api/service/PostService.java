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
        if(postRepository.findByNickname(postsDTO.user_id()).isEmpty()) {
            ResponseEntity.ok("Post Created");
        }  else {
            throw new RuntimeException("Needs to register before post");
        }
        Post createPostsDTO = postMapper.mapToPostCreation(postsDTO);
        Post SavePosts = postRepository.save(createPostsDTO);

        return SavePosts;
    }


}
