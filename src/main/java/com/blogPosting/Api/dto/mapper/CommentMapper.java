package com.blogPosting.Api.dto.mapper;


import com.blogPosting.Api.dto.CommentCreateDTO;
import com.blogPosting.Api.dto.CommentResponseDTO;
import com.blogPosting.Api.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public Comment mapToCommentCreation(CommentCreateDTO commentCreateDTO) {
        Comment comment = new Comment();
        comment.setId(commentCreateDTO.Id());
        comment.setTitle(commentCreateDTO.title());
        comment.setBody(commentCreateDTO.text());
        return comment;
    }

    public CommentResponseDTO mapToCommentResponse(Comment comment) {
        return new CommentResponseDTO(
                comment.getId(),
                comment.getTitle(),
                comment.getUsers().getId(),
                comment.getUsers().getNickname(),
                comment.getPost().getId(),
                comment.getPost().getTitle()
        );
    }
}
