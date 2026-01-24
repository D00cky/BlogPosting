package com.blogPosting.Api.dto;


import com.blogPosting.Api.entity.Comment;

import java.util.List;

public record CreatePostsDTO(String title,
                             String author,
                             String body,
                             List<Comment> comments) {
}
