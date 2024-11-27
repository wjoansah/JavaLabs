package com.wjoansah.auth;

import com.wjoansah.auth.dtos.AuthRequest;
import com.wjoansah.auth.dtos.AuthResponse;
import com.wjoansah.users.UserService;
import com.wjoansah.users.dtos.CreateUserDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;


@Service
public class JwtAuthProvider implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    public JwtAuthProvider(AuthenticationManager authenticationManager, UserService userService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        ));

        var user = userService.findUserByEmail(request.email());
        var token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse register(CreateUserDTO request) {
        var user = userService.createUser(request).orElse(null);
        var token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }
}
