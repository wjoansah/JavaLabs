package org.wjoansah.lab5;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.wjoansah.lab5.auth.AdminConfig;
import org.wjoansah.lab5.user.Role;
import org.wjoansah.lab5.user.User;
import org.wjoansah.lab5.user.UserRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab5Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository repository, AdminConfig adminConfig, PasswordEncoder passwordEncoder) {

        return args -> {
            var admin = User.builder()
                    .name(adminConfig.getName())
                    .email(adminConfig.getEmail())
                    .password(passwordEncoder.encode(adminConfig.getPassword()))
                    .role(Role.ADMIN)
                    .build();

            repository.save(admin);
        };
    }
}
