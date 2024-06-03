package org.wjoansah.lab4.product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}
