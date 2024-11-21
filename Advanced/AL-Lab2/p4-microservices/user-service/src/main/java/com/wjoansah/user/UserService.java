package com.wjoansah.user;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    String loginUser(LoginRequest request);
    User getUserById(int id);
    boolean existsUser(int id);
    List<User> getAllUsers();
}
