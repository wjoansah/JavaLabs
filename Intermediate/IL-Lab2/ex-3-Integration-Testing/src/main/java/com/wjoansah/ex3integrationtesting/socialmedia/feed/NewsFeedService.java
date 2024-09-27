package com.wjoansah.ex3integrationtesting.socialmedia.feed;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedService {
    private final PostRepository postRepository;

    public NewsFeedService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getNewsFeed(String username) {
        return postRepository.findPostsByUsername(username);
    }
}
