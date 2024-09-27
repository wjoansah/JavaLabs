package com.wjoansah.ex3integrationtesting.socialmedia;

import com.wjoansah.ex3integrationtesting.socialmedia.auth.UserLoginService;
import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfile;
import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserIntegrationTest {
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserLoginService userLoginService;

    @Test
    public void testUserLoginWithProfile() {
        UserProfile profile = new UserProfile("johnDoe", "john@example.com", "Hello world!");
        userProfileService.createProfile(profile);

        boolean result = userLoginService.login("johnDoe", "dummyPassword");
        assertTrue(result);
    }
}
