package org.wjoansah.ex1springsecurityjwtauth.auth;

import org.wjoansah.ex1springsecurityjwtauth.auth.dtos.AuthRequest;
import org.wjoansah.ex1springsecurityjwtauth.auth.dtos.AuthResponse;
import org.wjoansah.ex1springsecurityjwtauth.user.dtos.CreateUserRequest;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);

    AuthResponse register(CreateUserRequest request);
}
