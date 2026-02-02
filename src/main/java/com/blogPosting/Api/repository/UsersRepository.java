package com.blogPosting.Api.repository;

import com.blogPosting.Api.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByEmail(String email);
    Optional<Users> findByNickname(String name);
}
