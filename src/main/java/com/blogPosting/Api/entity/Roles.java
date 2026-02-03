package com.blogPosting.Api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Roles {
    @Id
    Long id;

    @Column(name = "role_name")
    String roles;
}
