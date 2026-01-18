package com.blogPosting.Api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Post {
    @Id
    Long Id;

    @Column(name="title")
    String title;

    @Column(name="text")
    String body;

    @Column(name="author")
    String nickname;
}
