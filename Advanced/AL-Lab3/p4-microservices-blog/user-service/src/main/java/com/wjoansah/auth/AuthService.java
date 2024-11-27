package com.wjoansah.auth;

import com.wjoansah.auth.dtos.AuthRequest;
import com.wjoansah.auth.dtos.AuthResponse;
import com.wjoansah.users.dtos.CreateUserDTO;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);

    AuthResponse register(CreateUserDTO request);
}
