package com.wjoansah.order;

import com.wjoansah.order.dtos.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(Order order);
    Order getOrderById(int id);
}
