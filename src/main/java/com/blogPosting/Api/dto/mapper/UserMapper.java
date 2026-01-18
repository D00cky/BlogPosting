package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.UsersPostsDTO;
import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.enums.Role;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
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

    public UsersPostsDTO mapToPostResponse(Post post) {
        return new UsersPostsDTO(post.getId(), post.getTitle());
    }

    public Users mapToUser (UsersRequestDTO usersRequest) {
        Users users = new Users();
        users.setNickname(usersRequest.nickname());
        users.setEmail(usersRequest.email());
        users.setPassword(usersRequest.password());
        return users;
    }

}
