package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.PostCreateDTO;
import com.blogPosting.Api.dto.PostResponseDTO;
import com.blogPosting.Api.entity.Post;

import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPostCreation(PostCreateDTO postsDTO) {
        Post post = new Post();
        post.setTitle(postsDTO.title());
        post.setBody(postsDTO.text());
        post.setNickname(postsDTO.author());
        return post;
    }

    public PostResponseDTO mapToPostResponse(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getUsers().getId(),
                post.getUsers().getNickname()
        );
    }
}
