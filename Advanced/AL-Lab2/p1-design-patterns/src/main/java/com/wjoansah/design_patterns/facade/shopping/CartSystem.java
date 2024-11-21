package com.wjoansah.design_patterns.facade.shopping;

import java.util.ArrayList;
import java.util.List;

public class CartSystem {
    private final List<String> items = new ArrayList<>();
    private double totalAmount = 0.0;

    public void addItem(String itemId, double price) {
        items.add(itemId);
        totalAmount += price;
        System.out.println("Added " + itemId + " to the cart. Current total: $" + totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void clearCart() {
        items.clear();
        totalAmount = 0.0;
    }
}
