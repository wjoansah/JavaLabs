package com.wjoansah.ex3integrationtesting.inventory.orders;

import com.wjoansah.ex3integrationtesting.inventory.cart.CartItem;
import com.wjoansah.ex3integrationtesting.inventory.cart.CartService;
import com.wjoansah.ex3integrationtesting.inventory.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService shoppingCartService;

    @Autowired
    private PaymentGateway paymentGateway; // Stub initially

    public boolean processOrder(String paymentDetails) {
        double totalAmount = shoppingCartService.calculateTotal();

        // Simulate payment processing via stub
        if (paymentGateway.processPayment(paymentDetails, totalAmount)) {
            for (CartItem item : shoppingCartService.getCartItems()) {
                productService.reduceProductQuantity(item.getProductName(), item.getQuantity());
            }
            shoppingCartService.clearCart();
            return true;
        }
        return false;
    }
}
