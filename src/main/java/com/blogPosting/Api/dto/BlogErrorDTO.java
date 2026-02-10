package com.blogPosting.Api.dto;

import com.blogPosting.Api.exception.BlogPostingErrorMessage;

public record BlogErrorDTO (BlogPostingErrorMessage code, String message){
}
