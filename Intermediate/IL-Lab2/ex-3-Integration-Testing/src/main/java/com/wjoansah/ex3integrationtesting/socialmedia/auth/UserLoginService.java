package com.wjoansah.ex3integrationtesting.socialmedia.auth;

import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfile;
import com.wjoansah.ex3integrationtesting.socialmedia.userprofile.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
 private final UserProfileRepository userProfileRepository;

    public UserLoginService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public boolean login(String username, String password) {
        UserProfile user = userProfileRepository.findByUsername(username);
        return user != null && password.equals("dummyPassword");
    }
}
