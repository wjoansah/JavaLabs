package com.wjoansah.user;

public interface UserService {
    User registerUser(User user);
    String loginUser(LoginRequest request);
    User getUserById(int id);
    boolean existsUser(int id);
}
