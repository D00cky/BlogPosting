package com.blogPosting.Api.repository;

import com.blogPosting.Api.entity.Comment;
import com.blogPosting.Api.entity.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.title = :title")
    Post findByPostTitle(@Param("title")String title);
}
