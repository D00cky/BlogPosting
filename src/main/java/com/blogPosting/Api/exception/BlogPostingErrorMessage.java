package com.blogPosting.Api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
@Getter
public enum BlogPostingErrorMessage {

    //USER
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User already exists"),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "Email not found"),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "Email already exists"),

    //POST
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post not found"),

    //COMMENT
    CREATE_COMMENT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create a comment"),
    COMMENT_NOT_EXISTS(HttpStatus.NOT_FOUND, "Comment not found"),

    //GENERIC
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong happened"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request");

    private final HttpStatus httpStatus;
    private final String description;

    private BlogPostingErrorMessage(HttpStatus httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public static HttpStatus getHttpStatus(BlogPostingErrorMessage errorMessage) {
        return Arrays.stream(BlogPostingErrorMessage.values())
                .filter(element -> element.equals(errorMessage))
                .findFirst()
                .map(element -> element.getHttpStatus())
                .orElse(null);
    }

    public static String getMessage(BlogPostingErrorMessage errorMessage) {
        return Arrays.stream(BlogPostingErrorMessage.values())
                .filter(element -> element.equals(errorMessage))
                .findFirst()
                .map(element -> element.getDescription())
                .orElse(null);
    }

    public static BlogPostingErrorMessage getFromHttpStatus(HttpStatus code) {
        return Arrays.stream(BlogPostingErrorMessage.values())
                .filter(element -> element.getHttpStatus().equals(code))
                .findFirst()
                .orElse(INTERNAL_SERVER_ERROR);
    }
}
