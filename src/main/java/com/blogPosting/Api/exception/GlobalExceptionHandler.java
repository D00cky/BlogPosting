package com.blogPosting.Api.exception;

import com.blogPosting.Api.dto.BlogErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogException.class)
    public ResponseEntity<BlogErrorDTO> handleBlogException(BlogException exception) {
        final BlogPostingErrorMessage errorMessage = exception.getErrorMessage();
        final HttpStatus status = BlogPostingErrorMessage.getHttpStatus(errorMessage);
        final BlogErrorDTO body = createBlogError(errorMessage);
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(value ={
            MethodArgumentTypeMismatchException.class,
    })
    public ResponseEntity<BlogErrorDTO> handleExceptions(MethodArgumentTypeMismatchException exception) {
        final BlogPostingErrorMessage errorMessage = BlogPostingErrorMessage.BAD_REQUEST;
        final HttpStatus status = BlogPostingErrorMessage.getHttpStatus(errorMessage);

        final String paramName = exception.getName();

        String requiredTypeName = "unknown";
        if (exception.getRequiredType() != null) {
            requiredTypeName = exception.getRequiredType().getSimpleName();
        }

        String providedTypeName = "unknown";
        if (exception.getValue() != null) {
            providedTypeName = exception.getValue().getClass().getSimpleName();
        }

        final String message = String.format(
                "Invalid value for parameter '%S'. Expected type: '%s', but got: '%s'.",
                paramName, requiredTypeName, providedTypeName
        );

        final BlogErrorDTO body = createBlogError(errorMessage, message);
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BlogErrorDTO> handleValidationExceptions(MethodArgumentNotValidException exception) {
        final Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach((error) -> {
                    final String fieldName = error.getField();
                    final String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
        });

        final BlogPostingErrorMessage errorMessage = BlogPostingErrorMessage.BAD_REQUEST;
        final HttpStatus status = BlogPostingErrorMessage.getHttpStatus(errorMessage);
        final BlogErrorDTO body = new BlogErrorDTO(errorMessage, errors.toString());
        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BlogErrorDTO> handleGenericException(Exception exception) {
        final BlogPostingErrorMessage errorMessage = BlogPostingErrorMessage.INTERNAL_SERVER_ERROR;
        final HttpStatus status = BlogPostingErrorMessage.getHttpStatus(errorMessage);
        final BlogErrorDTO body = createBlogError(errorMessage);
        return ResponseEntity.status(status).body(body);
    }
    private BlogErrorDTO createBlogError(BlogPostingErrorMessage errorMessage) {
        final String message = BlogPostingErrorMessage.getMessage(errorMessage);
        return new BlogErrorDTO(errorMessage, message);
    }

    private BlogErrorDTO createBlogError(BlogPostingErrorMessage errorMessage, String message){
        return new BlogErrorDTO(errorMessage, message);
    }

}
