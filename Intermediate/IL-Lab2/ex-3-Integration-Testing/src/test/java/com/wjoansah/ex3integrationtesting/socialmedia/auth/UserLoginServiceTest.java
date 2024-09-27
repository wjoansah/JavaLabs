package com.wjoansah.ex3integrationtesting.socialmedia.auth;

import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfile;
import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserLoginServiceTest {
    @MockBean
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserLoginService userLoginService;

    @Test
    public void testLoginSuccessful() {
        UserProfile user = new UserProfile("johnDoe", "john@example.com", "Hello world!");
        Mockito.when(userProfileRepository.findByUsername("johnDoe")).thenReturn(user);

        boolean result = userLoginService.login("johnDoe", "dummyPassword");
        assertTrue(result);
    }

    @Test
    public void testLoginFailure() {
        Mockito.when(userProfileRepository.findByUsername("johnDoe")).thenReturn(null);

        boolean result = userLoginService.login("johnDoe", "dummyPassword");
        assertFalse(result);
    }
}
