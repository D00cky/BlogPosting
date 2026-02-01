package com.blogPosting.Api.dto;


import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.entity.Users;

import java.util.List;

public record CreatePostsDTO(String title,
                             String author,
                             String body,
                             Long user_id) {
}
