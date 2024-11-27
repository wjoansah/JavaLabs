package com.wjoansah;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        // Initialize with some products
        products.add(new Product("Laptop", 1200.00));
        products.add(new Product("Smartphone", 799.99));
        products.add(new Product("Headphones", 149.99));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> findProductById(String productId) {
        return products.stream().filter(p -> p.getId().equals(productId)).findFirst();
    }
}

