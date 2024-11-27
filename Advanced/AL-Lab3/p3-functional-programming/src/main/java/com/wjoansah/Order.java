package com.wjoansah;

import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<Product> products;
    private double totalAmount;
    private boolean paymentStatus;

    public Order(List<Product> products, double totalAmount) {
        this.id = UUID.randomUUID().toString();
        this.products = products;
        this.totalAmount = totalAmount;
        this.paymentStatus = false;
    }

    public void confirmPayment() {
        this.paymentStatus = true;
    }

    public String getId() {
        return id;
    }

    public boolean isPaid() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", totalAmount=" + totalAmount + ", paymentStatus=" + paymentStatus + '}';
    }
}
