package com.wjoansah;

import java.util.Optional;
import java.util.Scanner;

public class FunctionalProgrammingApp {
    private final static ProductService productService = new ProductService();
    private final static OrderService orderService = new OrderService();
    private final static Cart cart = new Cart();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the E-Commerce Console App!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addProductToCart();
                case 3 -> viewCart();
                case 4 -> placeOrder();
                case 5 -> viewOrders();
                case 6 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : productService.getAllProducts()) {
            System.out.println(product);
        }
    }

    private static void addProductToCart() {
        System.out.print("Enter the Product ID to add to cart: ");
        String productId = scanner.nextLine();
        Optional<Product> product = productService.findProductById(productId);

        if (product.isPresent()) {
            cart.addProduct(product.get());
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void viewCart() {
        System.out.println("\nYour Cart:");
        for (Product product : cart.getProducts()) {
            System.out.println(product);
        }
        System.out.println("Total Amount: $" + cart.getTotalAmount());
    }

    private static void placeOrder() {
        if (cart.getProducts().isEmpty()) {
            System.out.println("Cart is empty. Please add products to place an order.");
            return;
        }

        Order order = orderService.createOrder(cart);
        System.out.println("Order placed successfully. Order ID: " + order.getId());
        System.out.print("Confirm payment (yes/no): ");

        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            order.confirmPayment();
            System.out.println("Payment confirmed!");
        } else {
            System.out.println("Payment not confirmed.");
        }
    }

    private static void viewOrders() {
        System.out.println("\nYour Orders:");
        for (Order order : orderService.getUserOrders()) {
            System.out.println(order);
        }
    }
}
