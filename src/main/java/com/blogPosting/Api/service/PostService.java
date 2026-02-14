package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.PostCreateDTO;
import com.blogPosting.Api.dto.PostResponseDTO;
import com.blogPosting.Api.dto.mapper.PostMapper;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.exception.BlogException;
import com.blogPosting.Api.exception.BlogPostingErrorMessage;
import com.blogPosting.Api.repository.PostRepository;
import com.blogPosting.Api.repository.UsersRepository;

import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


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
    @Cacheable(value = "posts")
    public Page<PostResponseDTO> findAll(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(postMapper::mapToPostResponse);
    }

    @Transactional
    @CacheEvict(value = "posts", allEntries = true)
    public PostResponseDTO createPost(PostCreateDTO postCreateDTO) {
        //1. check if the users is already registered.
        Users users = usersRepository.findUserByNickname(postCreateDTO.author())
                .orElseThrow(() -> {
                    return new BlogException(BlogPostingErrorMessage.USER_NOT_FOUND);});
        //3. if true then create post
        Post post = postMapper.mapToPostCreation(postCreateDTO, users);
        //4. save the post into the database.
        Post savePost = postRepository.save(post);
        //5. return message that the post is created.
        return postMapper.mapToPostResponse(savePost);
    }



}

