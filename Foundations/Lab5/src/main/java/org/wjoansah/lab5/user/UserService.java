package org.wjoansah.lab5.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.wjoansah.lab5.user.UserSpecifications.isUser;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> createUser(UserCreateRequest createRequest) {
        var user = User.builder()
                .name(createRequest.getName())
                .email(createRequest.getEmail())
                .password(passwordEncoder.encode(createRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return userRepository.findByEmail(createRequest.getEmail());
    }

    @Override
    public List<UserResponse> getAllUsers() {
        var users = userRepository.findAll(isUser());
        List<UserResponse> response =
                users.stream()
                        .map(u -> mapper.map(u, UserResponse.class))
                        .collect(Collectors.toList());


        return response;
    }
}
