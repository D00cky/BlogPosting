package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.UsersPostsDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.model.Post;
import com.blogPosting.Api.model.Users;

public class UserMapper {

    public UsersResponseDTO mapToUserResponse(Users users) {
        return new UsersResponseDTO(
                users.getId(),
                users.getNickname(),
                users.getEmail(),
                users.getPosts()
                        .stream()
                        .map(this::mapToPostResponse)
                        .toList());
    }

//    public UsersPostsDTO mapToPostResponse(Post post) {
//        return new UsersPostsDTO(post.getId(), post.get)
//    }
}
