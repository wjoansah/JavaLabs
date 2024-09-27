package com.wjoansah.ex3integrationtesting.socialmedia.feed;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUsername(String username);
}
