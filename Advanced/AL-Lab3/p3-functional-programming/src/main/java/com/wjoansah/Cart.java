package com.wjoansah;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    public void removeProduct(String productId) {
        products.removeIf(p -> p.getId().equals(productId));
        System.out.println("Product removed from the cart.");
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
