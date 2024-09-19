package com.wjoansah.ex3integrationtesting.ecommerce.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Method to retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to find a product by its ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Method to save a product (useful for adding/updating products)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Method to delete a product by its ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
