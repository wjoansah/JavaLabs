package org.wjoansah.ex1springsecurityjwtauth.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.wjoansah.ex1springsecurityjwtauth.user.dtos.CreateUserRequest;
import org.wjoansah.ex1springsecurityjwtauth.user.dtos.UserResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> createUser(CreateUserRequest request) {
        var user = modelMapper.map(request, User.class);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return userRepository.findByEmail(request.getEmail());
    }

    public List<UserResponse> findAllUsers() {
        var users = userRepository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserResponse.class)).collect(Collectors.toList());
    }
}
