package com.wjoansah.ex2unitvsintegrationtesting.Orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class OrderServiceImplIntegrationTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrder() {
        // Given
        Order order = new Order("ProductA", 2, 50.0);

        // When
        Order savedOrder = orderService.saveOrder(order);

        // Then
        assertNotNull(savedOrder.getId());  // Check that the order has an ID after saving
        assertEquals("ProductA", savedOrder.getProduct());
        assertEquals(2, savedOrder.getQuantity());
        assertEquals(50.0, savedOrder.getPrice());

        // Fetch the order from the database and verify
        Order fetchedOrder = orderRepository.findById(savedOrder.getId()).orElse(null);
        assertNotNull(fetchedOrder);
        assertEquals(savedOrder.getId(), fetchedOrder.getId());
        assertEquals("ProductA", fetchedOrder.getProduct());
        assertEquals(2, fetchedOrder.getQuantity());
        assertEquals(50.0, fetchedOrder.getPrice());
    }
}