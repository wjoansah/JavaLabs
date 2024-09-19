package com.wjoansah.ex3integrationtesting.ecommerce.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method to save an order
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Method to retrieve all orders (optional, could be useful for an admin interface)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Method to find an order by its ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Method to delete an order by its ID
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
