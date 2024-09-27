package com.wjoansah.ex3integrationtesting.socialmedia;

import com.wjoansah.ex3integrationtesting.socialmedia.auth.UserLoginService;
import com.wjoansah.ex3integrationtesting.socialmedia.feed.NewsFeedService;
import com.wjoansah.ex3integrationtesting.socialmedia.feed.Post;
import com.wjoansah.ex3integrationtesting.socialmedia.feed.PostRepository;
import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfile;
import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FullUserIntegrationTest {
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private NewsFeedService newsFeedService;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testFullUserFlow() {
        UserProfile profile = new UserProfile("johnDoe", "john@example.com", "Hello world!");
        userProfileService.createProfile(profile);

        postRepository.save(new Post("johnDoe", "Hello world!"));

        boolean loginSuccess = userLoginService.login("johnDoe", "dummyPassword");
        assertTrue(loginSuccess);

        List<Post> feed = newsFeedService.getNewsFeed("johnDoe");
        assertEquals(1, feed.size());
    }
}
