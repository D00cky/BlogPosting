package com.blogPosting.Api.dto;

public record CommentResponseDTO(Long id,
                                 String title,
                                 Long usersId,
                                 String userNickname,
                                 Long postId,
                                 String postTitle) {
}
