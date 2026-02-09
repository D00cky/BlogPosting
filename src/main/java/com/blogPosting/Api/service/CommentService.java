package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.CommentCreateDTO;
import com.blogPosting.Api.dto.CommentResponseDTO;
import com.blogPosting.Api.dto.mapper.CommentMapper;
import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.exception.ResourceNotFoundException;
import com.blogPosting.Api.repository.CommentRepository;
import com.blogPosting.Api.repository.PostRepository;
import com.blogPosting.Api.repository.UsersRepository;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;

    public CommentService(CommentMapper commentMapper, CommentRepository commentRepository,
                          PostRepository postRepository, UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }
    @Transactional
    public CommentResponseDTO createComment(CommentCreateDTO commentCreateDTO) {

        //1. Check if the post Exists
        Post searchPost = postRepository.findByTitle(commentCreateDTO.title())
                .orElseThrow(()-> new ResourceNotFoundException("Post with the title not found: " + commentCreateDTO.title()));

        //2. Check if the user exists
        Users checkUser = usersRepository.findUserByNickname(commentCreateDTO.nickname())
                .orElseThrow(()-> new ResourceNotFoundException("User not found, check again: " + commentCreateDTO.nickname()));

        //3. Create comment in the post
        Comment comment = commentMapper.mapToCommentCreation(commentCreateDTO, searchPost, checkUser);

        //4. Save
        Comment saveComment = commentRepository.save(comment);

        //5. return
        return commentMapper.mapToCommentResponse(saveComment);
    }
}
