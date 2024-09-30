package com.wjoansah;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EfficientOrderProcessingSystem {
    private List<Order> orders = new ArrayList<>();


    public void addOrder(Order order) {
        orders.add(order);
    }

    public static void main(String[] args) {
        EfficientOrderProcessingSystem system = new EfficientOrderProcessingSystem();

        // Simulate adding orders to the system
        for (int i = 0; i < 10000; i++) {
            system.addOrder(new Order(i, "Product" + i, new Random().nextInt(1000)));
        }

        // Profile this: inefficient total price calculation
        system.calculateTotalOrderAmount();

        // Profile this: inefficient search for an order
        Order order = system.findOrderById(5000);
        if (order != null) {
            System.out.println("Order found: " + order);
        }

        // Profile this: String concatenation inefficiency
        system.generateOrderSummary();

        // Intentional memory leak: Holding references unnecessarily
//        system.leakMemory();
    }

    private void generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        for (Order order : orders) {

            summary.append("Order ID: " + order.getId() + ", Product: " + order.getProductName() + ", Amount: " + order.getAmount() + "\n");
//            summary.append("Order ID: ")
//                    .append(order.getId())
//                    .append(", Product: ")
//                    .append(order.getProductName())
//                    .append(", Amount: ")
//                    .append(order.getAmount())
//                    .append("\n");
        }
        System.out.println(summary);
    }

    private Order findOrderById(int i) {
        return orders.stream().filter(order -> order.getId() == i).findFirst().orElse(null);
    }

    private double calculateTotalOrderAmount() {
        return orders.stream().reduce(0.0, (total, current) -> total + current.getAmount(), Double::sum);
    }
}
