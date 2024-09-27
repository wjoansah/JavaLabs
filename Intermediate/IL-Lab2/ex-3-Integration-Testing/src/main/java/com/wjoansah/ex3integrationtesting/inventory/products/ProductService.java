package com.wjoansah.ex3integrationtesting.inventory.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public boolean reduceProductQuantity(String name, int quantity) {
        Optional<Product> productOpt = productRepository.findByName(name);
        if (productOpt.isPresent() && productOpt.get().getQuantity() >= quantity) {
            Product product = productOpt.get();
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}
