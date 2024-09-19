package com.wjoansah.ex3integrationtesting.library.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String password, String fullName) {
        var user = new User(username, password, fullName);
        return userRepository.save(user);
    }
}
