package com.wjoansah.ex3integrationtesting.ecommerce.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
