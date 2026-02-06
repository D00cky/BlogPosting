package com.blogPosting.Api.repository;

import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Users;


import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value= "SELECT u FROM Users u WHERE u.email = :email")
     Users findByEmail(@Param("email")String email);

    @Query("SELECT u FROM Users u WHERE u.nickname = :nickname")
    Users findUserByName(@Param("nickname")String nickname);
}
