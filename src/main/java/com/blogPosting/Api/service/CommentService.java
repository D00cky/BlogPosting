package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.CommentCreateDTO;
import com.blogPosting.Api.dto.CommentResponseDTO;
import com.blogPosting.Api.dto.mapper.CommentMapper;
import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.repository.CommentRepository;
import com.blogPosting.Api.repository.PostRepository;
import com.blogPosting.Api.repository.UsersRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

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

//    public CommentResponseDTO createComment(CommentCreateDTO commentCreateDTO) {
//        Post post = postRepository.findByPostTitle(commentCreateDTO.title());
//        Users users = usersRepository.findUserByName(commentCreateDTO.nickname());

//        Comment comment = commentMapper.mapToCommentCreation(commentCreateDTO);
//        comment.setUsers(users);
//        comment.setPost(post);

//        Comment saveComment = commentRepository.save(comment);
//        return commentMapper.mapToCommentResponse(saveComment);
//        return null;
//    }
}
