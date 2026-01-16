package com.blogPosting.Api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Post {
    @Id
    Long Id;

    @Column(name="title")
    String title;

    @Column(name="TEXT")
    String body;
}
