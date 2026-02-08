package com.blogPosting.Api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="email")
    private String email;

    @Column(name="nickname")
    private String nickname;

    @Column(name = "password")
    private String password;



}
