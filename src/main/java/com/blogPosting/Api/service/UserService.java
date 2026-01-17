package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.model.Users;
import com.blogPosting.Api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<UsersRequestDTO> createUser(Users user) {
        Users newUser = new Users();
    }
}