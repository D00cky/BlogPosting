package com.blogPosting.Api.controller;

import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.service.UserService;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController (UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<@NotNull UsersResponseDTO> createUsers(@RequestBody UsersRequestDTO request) {

        UsersResponseDTO responseDTO = service.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
