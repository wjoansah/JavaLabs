package org.wjoansah.lab5.user;

import java.util.Optional;

public interface IUserService {
    Optional<User> findUserByEmail(String email);
    void createUser(UserCreateRequest userCreateRequest);
}
