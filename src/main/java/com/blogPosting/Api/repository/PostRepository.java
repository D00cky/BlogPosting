package com.blogPosting.Api.repository;

import com.blogPosting.Api.entity.Post;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query("select p from Post p where p.title = :title")
    Optional<Post> findByTitle(String title);

    Optional<Post> findByNickname(String nickname);

    Page<Post> findByUsersId(Long userid, Pageable pageable);
}
