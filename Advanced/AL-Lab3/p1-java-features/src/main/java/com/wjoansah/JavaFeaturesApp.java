package com.wjoansah;

public class JavaFeaturesApp {
    public static void main(String[] args) {
        // Create a new Product instance
        Product product = new Product("Laptop", 999.99, "Electronics");

        SealedProduct laptop = new ElectronicsProduct("Laptop", 1200.00, "Dell", 24);
        SealedProduct tshirt = new ClothingProduct("T-Shirt", 20.00, "M", "Cotton");

        // Display product descriptions
        System.out.println(laptop.description());
        System.out.println(tshirt.description());

        // Access the fields using accessor methods
        String productName = product.name();        // Accessor for 'name'
        double productPrice = product.price();      // Accessor for 'price'
        String productCategory = product.category();// Accessor for 'category'

        // Display the product details
        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: $" + productPrice);
        System.out.println("Product Category: " + productCategory);

        // The Record also has a default toString() method:
        System.out.println("Product Details: " + product);
    }
}
