package com.wjoansah.users;

import com.fasterxml.jackson.datatype.jdk8.OptionalDoubleSerializer;
import com.wjoansah.users.dtos.CreateUserDTO;
import com.wjoansah.users.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO findUserByEmail(String email) {
        var user = userRepository.findByEmail(email).orElse(null);
        return User.toUserDTO(user);
    }

    public UserDTO findUserById(Integer id) {
        var user = userRepository.findById(id).orElse(null);
        return User.toUserDTO(user);
    }

    public Optional<User> createUser(CreateUserDTO request) {
        var user = CreateUserDTO.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return userRepository.findByEmail(request.getEmail());
    }

    public List<UserDTO> findAllUsers() {
        var users = userRepository.findAll();
        return users.stream().map(User::toUserDTO).collect(Collectors.toList());
    }

    public Boolean exists(Integer id) {
        return userRepository.existsById(id);
    }
}
