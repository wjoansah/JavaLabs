package org.wjoansah.ex2springsecurityoauth2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.wjoansah.ex2springsecurityoauth2.products.Product;
import org.wjoansah.ex2springsecurityoauth2.products.ProductRepository;

import java.util.List;

@SpringBootApplication
public class Ex2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            var products = List.of(
                    new Product(1, "product-1", "this is product 1", 33.0d, 400),
                    new Product(2, "product-2", "this is product 2", 33.0d, 400),
                    new Product(3, "product-3", "this is product 3", 33.0d, 400),
                    new Product(4, "product-4", "this is product 4", 33.0d, 400),
                    new Product(5, "product-5", "this is product 5", 33.0d, 400),
                    new Product(6, "product-6", "this is product 6", 33.0d, 400)
            );

            productRepository.saveAll(products);
        };
    }

}
