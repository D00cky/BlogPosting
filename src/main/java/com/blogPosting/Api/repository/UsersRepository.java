package com.blogPosting.Api.repository;

import com.blogPosting.Api.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByEmail(String email);
    List<Users> findByNickname(String name);
}
