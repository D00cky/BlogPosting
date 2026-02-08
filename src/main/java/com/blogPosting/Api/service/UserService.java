package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.dto.mapper.UserMapper;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.repository.UsersRepository;

import jakarta.transaction.Transactional;
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

    @Transactional
    public UsersResponseDTO createUser(@NotNull UsersRequestDTO request) {
        // 1. check if the users exists
        if(usersRepository.findUserByNickname(request.nickname()).isPresent()
                || usersRepository.findByEmail(request.email()).isPresent()) {
            // 2. If the user exists, throw an error
            throw new RuntimeException("User Already Exists");
        }
        // 3. If not, create a new user.
        Users userEntity = userMapper.mapToUser(request);
        // 4. Save in the database.
        Users savedUser = usersRepository.save(userEntity);
        // 5. Returns message of user created.
        return userMapper.mapToUserResponse(savedUser);

    }
}