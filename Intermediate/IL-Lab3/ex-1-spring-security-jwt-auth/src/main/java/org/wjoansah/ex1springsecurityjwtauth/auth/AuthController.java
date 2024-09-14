package org.wjoansah.ex1springsecurityjwtauth.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjoansah.ex1springsecurityjwtauth.auth.dtos.AuthRequest;
import org.wjoansah.ex1springsecurityjwtauth.auth.dtos.AuthResponse;
import org.wjoansah.ex1springsecurityjwtauth.user.dtos.CreateUserRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(JwtAuthProvider authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok((authService.authenticate(request)));
    }
}
