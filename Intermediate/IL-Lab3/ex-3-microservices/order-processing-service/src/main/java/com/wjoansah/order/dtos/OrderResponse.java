package com.wjoansah.order.dtos;

import com.wjoansah.order.OrderStatus;

import java.util.Set;

public class OrderResponse {
    private Integer id;
    private Integer userId;
    private Set<OrderItemResponse> orderItems;
    private Double totalAmount;
    private OrderStatus status;

    public OrderResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<OrderItemResponse> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemResponse> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
