package com.blogPosting.Api.dto;

public record PostResponseDTO (Long id,
                               String title,
                               Long usersId,
                               String userNickname) {
}
