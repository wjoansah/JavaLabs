package com.wjoansah.ex3integrationtesting.inventory;

import com.wjoansah.ex3integrationtesting.inventory.cart.CartItem;
import com.wjoansah.ex3integrationtesting.inventory.products.Product;
import com.wjoansah.ex3integrationtesting.inventory.cart.CartService;
import com.wjoansah.ex3integrationtesting.inventory.orders.OrderService;
import com.wjoansah.ex3integrationtesting.inventory.orders.PaymentGateway;
import com.wjoansah.ex3integrationtesting.inventory.products.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FullSystemIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService shoppingCartService;

    @Qualifier("RealPaymentGateway")
    @Autowired
    private PaymentGateway paymentGateway;

    @Test
    void testCompleteOrderProcessing() {
        // Add product to inventory
        Product product = new Product();
        product.setName("Laptop");
        product.setQuantity(10);
        product.setPrice(1000.0);
        productService.addProduct(product);

        // Add product to cart
        CartItem item = new CartItem();
        item.setProductName("Laptop");
        item.setQuantity(1);
        item.setPrice(1000.0);
        shoppingCartService.addToCart(item);

        // Process the order
        boolean result = orderService.processOrder("valid-payment-details");
        assertTrue(result);

        // Verify the product quantity was reduced
        Optional<Product> updatedProduct = productService.getProductByName("Laptop");
        assertTrue(updatedProduct.isPresent());
        assertEquals(9, updatedProduct.get().getQuantity());
    }
}
