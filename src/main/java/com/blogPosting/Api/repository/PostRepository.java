package com.blogPosting.Api.repository;

import com.blogPosting.Api.entity.Post;
import com.blogPosting.Api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(String nickname);
    List<Post> findByTitle(String title);
    List<Users> findByEmail(String email);
}
