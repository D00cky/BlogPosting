package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Post;

import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPostCreation(CreatePostsDTO postsDTO) {
        Post post = new Post();
        post.setTitle(postsDTO.title());
        post.setBody(postsDTO.body());
        post.setNickname(postsDTO.author());
        return post;
    }
}
