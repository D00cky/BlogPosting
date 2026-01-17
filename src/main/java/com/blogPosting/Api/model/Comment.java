package com.blogPosting.Api.model;

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
public class Comment {
    @Id
    Long id;

    @Column(name="title")
    String title;

    @Column(name="text")
    String body;


}
