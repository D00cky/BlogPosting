package com.blogPosting.Api.controller;

import com.blogPosting.Api.dto.CommentCreateDTO;
import com.blogPosting.Api.dto.CommentResponseDTO;
import com.blogPosting.Api.service.CommentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<@NotNull CommentResponseDTO> createComment(@RequestBody CommentCreateDTO commentCreateDTO) {
        CommentResponseDTO responseDTO = commentService.createComment(commentCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
