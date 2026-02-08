package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.PostCreateDTO;
import com.blogPosting.Api.dto.PostResponseDTO;
import com.blogPosting.Api.entity.Post;

import com.blogPosting.Api.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPostCreation(PostCreateDTO postsDTO, Users users) {
        Post post = new Post();
        post.setTitle(postsDTO.title());
        post.setNickname(postsDTO.author());
        post.setBody(postsDTO.text());
        post.setUsers(users);
        return post;
    }

    public PostResponseDTO mapToPostResponse(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getUsers().getNickname()
        );
    }
}
