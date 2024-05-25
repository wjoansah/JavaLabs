package org.wjoansah.lab3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getUsers();
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void addUser(User user) {
        User user1 = userRepository.getUserByEmail(user.getEmail());
        if (user1 != null) {
            throw new IllegalStateException("User already exists");
        }
        userRepository.addUser(user);
    }

    public void removeUser(String email) {
        var user = userRepository.getUserByEmail(email);
        if (user == null) {
            return;
        }
        userRepository.removeUser(user);
    }

    public void updateUser(String email, User user) {
        var user1 = userRepository.getUserByEmail(email);

        if (user1 == null) {
            throw new IllegalStateException("User does not exist");
        }

        if (user.getName() != null)
            user1.setName(user.getName());

        if (user.getPhoneNumber() != null)
            user1.setPhoneNumber(user.getPhoneNumber());
    }
}
