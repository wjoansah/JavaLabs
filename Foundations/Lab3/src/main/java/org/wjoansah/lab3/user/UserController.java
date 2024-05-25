package org.wjoansah.lab3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
         userService.addUser(user);
    }

    @PutMapping("{email}")
    public void updateUser(@PathVariable String email, @RequestBody User user) {
        userService.updateUser(email, user);
    }

    @DeleteMapping("{email}")
    public void deleteUser(@PathVariable String email) {
        userService.removeUser(email);
    }
}
