package com.wjoansah.ex3integrationtesting.inventory.cart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @InjectMocks
    private CartService shoppingCartService;

    @Test
    void testAddToCartAndCalculateTotal() {
        CartItem item1 = new CartItem();
        item1.setProductName("Laptop");
        item1.setQuantity(1);
        item1.setPrice(1000.0);

        CartItem item2 = new CartItem();
        item2.setProductName("Mouse");
        item2.setQuantity(2);
        item2.setPrice(25.0);

        shoppingCartService.addToCart(item1);
        shoppingCartService.addToCart(item2);

        List<CartItem> cartItems = shoppingCartService.getCartItems();
        assertEquals(2, cartItems.size());
        assertEquals(1050.0, shoppingCartService.calculateTotal(), 0.01);
    }

    @Test
    void testClearCart() {
        CartItem item = new CartItem();
        item.setProductName("Laptop");
        item.setQuantity(1);
        item.setPrice(1000.0);

        shoppingCartService.addToCart(item);
        shoppingCartService.clearCart();
        assertEquals(0, shoppingCartService.getCartItems().size());
    }
}
