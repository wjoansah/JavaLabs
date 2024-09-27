package com.wjoansah.ex3integrationtesting.inventory.cart;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(CartItem item) {
        cartItems.add(item);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
}
