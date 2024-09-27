package com.wjoansah.ex4mvc;

import com.wjoansah.ex4mvc.todos.TodoItem;
import com.wjoansah.ex4mvc.todos.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Ex4Application {
    public static void main(String[] args) {
        SpringApplication.run(Ex4Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository) {
        return args -> {
            var todos = List.of(
                    new TodoItem("Trash", "take out the trash", false),
                    new TodoItem("Family", "Call mom", false),
                    new TodoItem("Health", "take a walk", true)
            );
            repository.saveAll(todos);
        };
    }
}
