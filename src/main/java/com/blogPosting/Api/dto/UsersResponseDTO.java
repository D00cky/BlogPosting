package com.blogPosting.Api.dto;

import java.util.List;

public record UsersResponseDTO(String nickname,
                               String email,
                               List<UsersPostsDTO> posts) {

}

