package com.wjoansah;

import com.wjoansah.user.User;
import com.wjoansah.user.UserRepository;
import com.wjoansah.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            var users = List.of(
                    new User("user1", "user1Password", "user1@email.com", "010-100-2000"),
                    new User("user2", "user2Password", "user2@email.com", "010-100-3000"),
                    new User("user3", "user3Password", "user3@email.com", "010-100-4000")
            );

            repository.saveAll(users);
        };
    }
}
