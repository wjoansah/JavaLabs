package org.wjoansah.ex1springsecurityjwtauth.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjoansah.ex1springsecurityjwtauth.user.dtos.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        var users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
}
