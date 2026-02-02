package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.dto.mapper.PostMapper;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.repository.PostRepository;

import com.blogPosting.Api.repository.UsersRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;

    public PostService(PostMapper postMapper, PostRepository postRepository, UsersRepository usersRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
        this.usersRepository = usersRepository;
    }

    public Post createPost(@NotNull CreatePostsDTO postsDTO) {
        // check if the user exists in the Users table
            if(usersRepository.findByNickname(postsDTO.author()) != null && usersRepository.findByNickname(postsDTO.author()).isEmpty()) {
                throw new RuntimeException("Usuario nao encontrado");
            } else {
                Post CreatePost = postMapper.mapToPostCreation(postsDTO);
                Post SavePost = postRepository.save(CreatePost);
                ResponseEntity.ok("Post created");
                return postMapper.mapToPostCreation(postsDTO);
            }
        }
    }
