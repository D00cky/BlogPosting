package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.dto.UsersPostsDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PostMapper {

    public CreatePostsDTO mapToPostCreation(Post post) {
        return new CreatePostsDTO(
                post.getTitle(),
                post.getNickname(),
                post.getBody(),
                (List<Users>) post.getUsers(),
                (List<Comment>) post.getComment());
    }
}
