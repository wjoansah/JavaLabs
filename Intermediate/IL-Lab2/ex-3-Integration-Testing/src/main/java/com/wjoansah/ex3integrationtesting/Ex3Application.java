package com.wjoansah.ex3integrationtesting;

import com.wjoansah.ex3integrationtesting.ecommerce.Products.Product;
import com.wjoansah.ex3integrationtesting.ecommerce.Products.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Ex3Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex3Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            var products = new ArrayList<Product>();
            products.add(new Product("product a", 1.0));
            products.add(new Product("product b", 2.0));
            products.add(new Product("product c", 3.0));
            products.add(new Product("product d", 4.0));
            products.add(new Product("product e", 5.0));

            productRepository.saveAll(products);
        };
    }

}
