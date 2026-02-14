package com.blogPosting.Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class BlogPostingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogPostingApiApplication.class, args);
	}
}
