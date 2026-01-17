package com.blogPosting.Api.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record UsersRequestDTO(@NotNull String name,
                              @NotNull String email,
                              @NotNull String password) {
}
