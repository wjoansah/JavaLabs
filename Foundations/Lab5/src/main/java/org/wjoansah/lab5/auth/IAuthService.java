package org.wjoansah.lab5.auth;

import org.wjoansah.lab5.user.UserCreateRequest;

public interface IAuthService {

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse register(UserCreateRequest request);
}

