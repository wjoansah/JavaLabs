package org.wjoansah.ex1springsecurityjwtauth.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.wjoansah.ex1springsecurityjwtauth.auth.dtos.AuthRequest;
import org.wjoansah.ex1springsecurityjwtauth.auth.dtos.AuthResponse;
import org.wjoansah.ex1springsecurityjwtauth.user.UserService;
import org.wjoansah.ex1springsecurityjwtauth.user.dtos.CreateUserRequest;

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

        var user = userService.findUserByEmail(request.email()).get();

        var token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse register(CreateUserRequest request) {
        var user = userService.createUser(request).orElse(null);

        var token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }
}
