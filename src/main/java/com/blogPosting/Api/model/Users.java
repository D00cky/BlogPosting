package com.blogPosting.Api.model;

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
public class Users {

    @Id
    Long Id;

    @Column(name="email")
    String email;

    @Column(name="nickname")
    String nickname;

    @Column(name = "password")
    String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Post> posts = new ArrayList<>();
}
