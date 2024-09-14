package org.wjoansah.ex1springsecurityjwtauth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.wjoansah.ex1springsecurityjwtauth.config.AdminConfig;
import org.wjoansah.ex1springsecurityjwtauth.user.Role;
import org.wjoansah.ex1springsecurityjwtauth.user.User;
import org.wjoansah.ex1springsecurityjwtauth.user.UserRepository;

@SpringBootApplication
public class Ex1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository repository,
    AdminConfig adminConfig,
    PasswordEncoder passwordEncoder
    ) {

        return args -> {
            var admin = new User();
            admin.setName(adminConfig.getName());
            admin.setEmail(adminConfig.getEmail());
            admin.setPassword(passwordEncoder.encode(adminConfig.getPassword()));
            admin.setRole(Role.ADMIN);

            repository.save(admin);
        };
    }

}
