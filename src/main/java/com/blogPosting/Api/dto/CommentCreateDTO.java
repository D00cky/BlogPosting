package com.blogPosting.Api.dto;

public record CommentCreateDTO(Long Id,
                               String title,
                               String nickname,
                               String text) {
}
