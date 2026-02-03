package com.blogPosting.Api.dto.mapper;

import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UsersResponseDTO mapToUserResponse(Users users) {
        return new UsersResponseDTO(
                users.getNickname(),
                users.getEmail());
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
