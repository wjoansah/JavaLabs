package org.wjoansah.lab5.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public void createUser(UserCreateRequest createRequest) {
        var user = User.builder()
                .name(createRequest.getName())
                .email(createRequest.getEmail())
                .password(createRequest.getPassword())
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }
}
