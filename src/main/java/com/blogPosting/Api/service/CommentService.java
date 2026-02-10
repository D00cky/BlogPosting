package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.CommentCreateDTO;
import com.blogPosting.Api.dto.CommentResponseDTO;
import com.blogPosting.Api.dto.mapper.CommentMapper;
import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.exception.BlogException;
import com.blogPosting.Api.exception.BlogPostingErrorMessage;
import com.blogPosting.Api.repository.CommentRepository;
import com.blogPosting.Api.repository.PostRepository;
import com.blogPosting.Api.repository.UsersRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


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
        Post searchPostByTitle = postRepository.findByTitle(commentCreateDTO.title())
                .orElseThrow(() -> {
                    return new BlogException(BlogPostingErrorMessage.POST_NOT_FOUND);});

        //2. Check if the user exists
        Users checkUserByName = usersRepository.findUserByNickname(commentCreateDTO.nickname())
                .orElseThrow(() -> {
                    return new BlogException(BlogPostingErrorMessage.USER_NOT_FOUND);});

        //3. Create comment in the post
        Comment comment = commentMapper.mapToCommentCreation(commentCreateDTO, searchPostByTitle, checkUserByName);

        //4. Save
        Comment saveComment = commentRepository.save(comment);

        //5. return
        return commentMapper.mapToCommentResponse(saveComment);
    }
}
