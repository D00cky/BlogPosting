package com.blogPosting.Api.repository;

import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Users;


import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

//    @Query(value= "SELECT u FROM Users u WHERE u.email = :email", nativeQuery = true)
        Optional<Users> findByEmail(String email);

//    @Query(value = "SELECT u FROM Users u WHERE u.nickname = :nickname", nativeQuery = true)
        Optional<Users> findUserByNickname(String nickname);
}
