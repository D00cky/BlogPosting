package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.PostCreateDTO;
import com.blogPosting.Api.dto.PostResponseDTO;
import com.blogPosting.Api.dto.mapper.PostMapper;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.repository.PostRepository;
import com.blogPosting.Api.repository.UsersRepository;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;

    public PostService(PostMapper postMapper, PostRepository postRepository,
                       UsersRepository usersRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
        this.usersRepository = usersRepository;
    }

    public PostResponseDTO createPost(Long userId, PostCreateDTO postCreateDTO) {
        Users users = usersRepository.getReferenceById(userId);

        Post post = postMapper.mapToPostCreation(postCreateDTO);

        post.setUsers(users);

        Post savePost = postRepository.save(post);

        return postMapper.mapToPostResponse(savePost);
    }
}
