package com.wjoansah;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public Order createOrder(Cart cart) {
        Order order = new Order(cart.getProducts(), cart.getTotalAmount());
        orders.add(order);
        return order;
    }

    public List<Order> getUserOrders() {
        return orders;
    }
}
