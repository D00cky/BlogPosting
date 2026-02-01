package com.blogPosting.Api.repository;

import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Post;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.users.id = :userId")
    String findUserById(@Param("userId")Long userId);
}
