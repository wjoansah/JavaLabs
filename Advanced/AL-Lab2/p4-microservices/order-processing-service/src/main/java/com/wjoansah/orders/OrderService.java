package com.wjoansah.orders;

import com.wjoansah.orders.dtos.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(Order order);
    Order getOrderById(int id);
}
