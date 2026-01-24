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
    Long Id;

    @Column(name="title")
    String title;

    @Column(name="text")
    String body;

    @Column(name="author")
    String nickname;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    @OneToMany
    @JoinColumn(name="post_id")
    private List<Comment> comment = new ArrayList<>();
}

