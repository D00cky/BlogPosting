package com.blogPosting.Api.dto;

import java.util.List;

public record UsersResponseDTO(Long id,
                               String nickname,
                               String email,
                               List<UsersPostsDTO> posts) {

}

