package com.blogPosting.Api.controller;

import com.blogPosting.Api.dto.CommentCreateDTO;
import com.blogPosting.Api.dto.CommentResponseDTO;
import com.blogPosting.Api.dto.PostCreateDTO;
import com.blogPosting.Api.dto.PostResponseDTO;
import com.blogPosting.Api.dto.mapper.CommentMapper;
import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.repository.CommentRepository;
import com.blogPosting.Api.service.CommentService;
import com.blogPosting.Api.service.PostService;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public PostController (PostService postService, CommentService commentService,
                           CommentRepository commentRepository, CommentMapper commentMapper) {
        this.postService = postService;
        this.commentService = commentService;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @PostMapping // Creates the posts
    public ResponseEntity<@NotNull PostResponseDTO> createPosts(@RequestBody PostCreateDTO postsDTO) {
        PostResponseDTO responseDTO = postService.createPost(postsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    @GetMapping("/{postId}/comment")
    public ResponseEntity<Page<CommentResponseDTO>> getCommentsByPost(
            @PathVariable Long postId,
            Pageable pageable
    ){
        Page<Comment> comments = commentRepository.findByPostId(postId, pageable);
        return ResponseEntity.ok(comments.map(commentMapper::mapToCommentResponse));
    }

    @PostMapping("/{postId}/comment") //Creates the comment in the post
    public ResponseEntity<@NotNull CommentResponseDTO> createComment(@RequestBody CommentCreateDTO commentCreateDTO, @PathVariable Long postId) {
        CommentResponseDTO responseDTO = commentService.createComment(commentCreateDTO, postId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
