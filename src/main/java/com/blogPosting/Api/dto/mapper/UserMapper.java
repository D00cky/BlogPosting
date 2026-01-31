package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.CreatePostsDTO;
import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UsersResponseDTO mapToUserResponse(Users users) {
        return new UsersResponseDTO(
                users.getNickname(),
                users.getEmail(),
                users.getPosts()
                        .stream()
                        .map(this::mapToPostResponse)
                        .toList());
    }

    public CreatePostsDTO mapToPostResponse(Post post) {
        return new CreatePostsDTO(post.getTitle(), post.getBody(),
                post.getTitle(), post.getUsers(), post.getComment());
    }

    public Users mapToUser (UsersRequestDTO usersRequest) {
        Users users = new Users();
        users.setId(usersRequest.id());
        users.setNickname(usersRequest.nickname());
        users.setEmail(usersRequest.email());
        users.setPassword(usersRequest.password());
        return users;
    }

}
