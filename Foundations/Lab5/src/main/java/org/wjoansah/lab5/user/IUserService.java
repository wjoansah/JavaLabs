package org.wjoansah.lab5.user;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findUserByEmail(String email);
    Optional<User> createUser(UserCreateRequest userCreateRequest);

    List<UserResponse> getAllUsers();
}
