package com.wjoansah.ex3integrationtesting.socialmedia.userprofile;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserProfileServiceTest {
    @MockBean
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileService userProfileService;

    @Test
    public void testCreateProfile() {
        UserProfile profile = new UserProfile("johnDoe", "john@example.com", "Hello world!");
        Mockito.when(userProfileRepository.save(profile)).thenReturn(profile);

        UserProfile createdProfile = userProfileService.createProfile(profile);
        assertEquals("johnDoe", createdProfile.getUsername());
    }

    @Test
    public void testGetProfile() {
        UserProfile profile = new UserProfile("johnDoe", "john@example.com", "Hello world!");
        Mockito.when(userProfileRepository.findByUsername("johnDoe")).thenReturn(profile);

        UserProfile retrievedProfile = userProfileService.getProfile("johnDoe");
        assertEquals("john@example.com", retrievedProfile.getEmail());
    }
}
