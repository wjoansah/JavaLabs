package com.wjoansah.ex3integrationtesting.inventory.orders;

import com.wjoansah.ex3integrationtesting.inventory.cart.CartItem;
import com.wjoansah.ex3integrationtesting.inventory.cart.CartService;
import com.wjoansah.ex3integrationtesting.inventory.products.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private PaymentGateway paymentGateway;

    @MockBean
    private ProductService productService;

    @MockBean
    private CartService shoppingCartService;

    @Test
    void testProcessOrderWithMockPaymentGateway() {
        Mockito.when(shoppingCartService.calculateTotal()).thenReturn(500.0);
        Mockito.when(paymentGateway.processPayment(anyString(), anyDouble())).thenReturn(true);

        CartItem item = new CartItem();
        item.setProductName("Laptop");
        item.setQuantity(1);
        Mockito.when(shoppingCartService.getCartItems()).thenReturn(Collections.singletonList(item));

        boolean result = orderService.processOrder("dummy-payment-details");
        assertTrue(result);
        Mockito.verify(productService).reduceProductQuantity("Laptop", 1);
        Mockito.verify(shoppingCartService).clearCart();
    }
}
