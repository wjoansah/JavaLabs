package com.wjoansah.ex2unitvsintegrationtesting.Orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        Order order = new Order("ProductA", 2, 50.0);
        Order savedOrder = new Order("ProductA", 2, 50.0);
        savedOrder.setId(1L);

        // When
        when(orderRepository.save(order)).thenReturn(savedOrder);
        Order result = orderService.saveOrder(order);

        // Then
        assertEquals(savedOrder, result);
        verify(orderRepository, times(1)).save(order);
    }
}