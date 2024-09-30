package com.wjoansah;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderProcessingSystem {

    private List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        OrderProcessingSystem system = new OrderProcessingSystem();

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
        system.leakMemory();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    // Inefficient way to calculate total order amount by repeatedly creating objects
    public double calculateTotalOrderAmount() {
        double total = 0.0;
        for (Order order : orders) {
            total += new Double(order.getAmount()); // Inefficient object creation
        }
        System.out.println("Total Order Amount: " + total);
        return total;
    }

    // Inefficient linear search for an order by ID
    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    // Inefficient String concatenation (Should use StringBuilder)
    public String generateOrderSummary() {
        String summary = "";
        for (Order order : orders) {
            summary += "Order ID: " + order.getId() + ", Product: " + order.getProductName() + ", Amount: " + order.getAmount() + "\n";
        }
        System.out.println(summary);
        return summary;
    }

    // Memory leak: Holding a reference to a large list that is never cleared
    public void leakMemory() {
        List<byte[]> memoryLeakList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            memoryLeakList.add(new byte[1024 * 1024]); // Allocating 1MB objects
        }
        // The list memoryLeakList is never cleared, causing a memory leak
    }
}
