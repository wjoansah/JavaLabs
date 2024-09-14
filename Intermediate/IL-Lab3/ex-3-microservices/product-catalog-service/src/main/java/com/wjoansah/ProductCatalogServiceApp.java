package com.wjoansah;

import com.wjoansah.products.Product;
import com.wjoansah.products.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductCatalogServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogServiceApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            var products = List.of(
                    new Product("jenga set", 10.0d, "jenga set", 10),
                    new Product("uno set", 15.0d, "uno set", 10),
                    new Product("scrabble set", 20.0d, "scrabble set", 10),
                    new Product("chess set", 30.0d, "chess set", 10)
            );

            productRepository.saveAll(products);
        };
    }
}
