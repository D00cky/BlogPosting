package com.blogPosting.Api.controller;

import com.blogPosting.Api.dto.PostResponseDTO;
import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.dto.mapper.PostMapper;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.repository.PostRepository;
import com.blogPosting.Api.service.UserService;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final PostRepository postRepository;
    private final PostMapper postMapper;


    public UserController (UserService service, PostRepository postRepository, PostMapper postMapper) {
        this.service = service;
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @PostMapping
    public ResponseEntity<@NotNull UsersResponseDTO> createUsers(@RequestBody UsersRequestDTO request) {
        UsersResponseDTO responseDTO = service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("{userId}/posts")
    public ResponseEntity<Page<PostResponseDTO>> getPostsByUser(
            @PathVariable Long userId,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<Post> posts = postRepository.findByUsersId(userId, pageable);
        Page<PostResponseDTO> dtoPage = posts.map(postMapper::mapToPostResponse);
        return ResponseEntity.ok(dtoPage);
    }

}
