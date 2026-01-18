package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.dto.mapper.UserMapper;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.repository.UsersRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public UserService(UsersRepository usersRepository, UserMapper userMapper){
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    public UsersResponseDTO createUser(@NotNull UsersRequestDTO request) {
        if (usersRepository.findByEmail(request.email()).isEmpty()) {
            throw new RuntimeException("User already exists");
        }
        Users userEntity = userMapper.mapToUser(request);
        Users savedUser = usersRepository.save(userEntity);

        return userMapper.mapToUserResponse(savedUser);

    }


}