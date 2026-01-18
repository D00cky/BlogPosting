package com.blogPosting.Api.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record UsersRequestDTO(String nickname,
                              String email,
                              String password) {
}
