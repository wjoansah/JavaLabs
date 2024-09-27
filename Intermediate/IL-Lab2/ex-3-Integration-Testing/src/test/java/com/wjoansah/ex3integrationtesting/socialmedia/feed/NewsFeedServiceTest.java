package com.wjoansah.ex3integrationtesting.socialmedia.feed;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NewsFeedServiceTest {
    @MockBean
    private PostRepository postRepository;

    @Autowired
    private NewsFeedService newsFeedService;

    @Test
    public void testGetNewsFeed() {
        List<Post> posts = List.of(new Post("johnDoe", "Hello world!"));
        Mockito.when(postRepository.findPostsByUsername("johnDoe")).thenReturn(posts);

        List<Post> retrievedPosts = newsFeedService.getNewsFeed("johnDoe");
        assertEquals(1, retrievedPosts.size());
        assertEquals("Hello world!", retrievedPosts.get(0).getContent());
    }
}
