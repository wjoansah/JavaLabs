package com.wjoansah.ex2unitvsintegrationtesting.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
