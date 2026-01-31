package com.blogPosting.Api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String body;

    @Column(name="author")
    private String nickname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;

    @OneToMany
    @JoinColumn(name="post_id")
    private List<Comment> comment = new ArrayList<>();

}

