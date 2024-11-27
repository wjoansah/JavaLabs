package com.wjoansah.users;

import com.wjoansah.auth.AuthService;
import com.wjoansah.auth.dtos.AuthRequest;
import com.wjoansah.auth.dtos.AuthResponse;
import com.wjoansah.users.dtos.CreateUserDTO;
import com.wjoansah.users.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        var users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        var user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> userExists(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.exists(id));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody CreateUserDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok((authService.authenticate(request)));
    }
}
