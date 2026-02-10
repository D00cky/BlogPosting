package com.blogPosting.Api.exception;

import lombok.Getter;

@Getter
public class BlogException extends RuntimeException {

    private final BlogPostingErrorMessage errorMessage;

    public BlogException(BlogPostingErrorMessage errorMessage){
        super();
        this.errorMessage = errorMessage;
    }
}
