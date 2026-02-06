package com.blogPosting.Api.repository;

import com.blogPosting.Api.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
