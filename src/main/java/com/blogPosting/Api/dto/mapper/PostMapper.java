package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.entity.Post;

import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPostCreation(CreatePostsDTO postsDTO) {
        Post post = new Post();
        post.setTitle(postsDTO.title());
        post.setNickname(postsDTO.author());
        post.setBody(postsDTO.body());
        post.setUsers(postsDTO.user_id());
        post.setComment(postsDTO.comments());
        return post;
    }
}
