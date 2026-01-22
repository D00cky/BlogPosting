package com.blogPosting.Api.dto;

public record UsersRequestDTO(Long id,
                              String nickname,
                              String email,
                              String password) {
}
