package org.wjoansah.lab5.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.wjoansah.lab5.user.UserCreateRequest;
import org.wjoansah.lab5.user.UserService;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        var user = userService.findUserByEmail(request.getEmail()).get();

        var token = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(token).build();
    }

    @Override
    public AuthenticationResponse register(UserCreateRequest request) {
        var user = userService.createUser(request).get();

        var token = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(token).build();
    }
}
