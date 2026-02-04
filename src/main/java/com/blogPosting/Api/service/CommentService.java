package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.CommentCreateDTO;
import com.blogPosting.Api.dto.mapper.CommentMapper;
import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.repository.CommentRepository;
import com.blogPosting.Api.repository.PostRepository;
import com.blogPosting.Api.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;

    public CommentService(CommentMapper commentMapper, CommentRepository commentRepository,
                          PostRepository postRepository, UsersRepository usersRepository) {
                              this.commentMapper = commentMapper;
                              this.commentRepository = commentRepository;
                              this.postRepository = postRepository;
                              this.usersRepository = usersRepository;

    }

    public CommentResponseDTO (CommentCreateDTO commentCreateDTO) {
        Post post = postRepository.findByPostTitle(commentCreateDTO.title());

    }
}
