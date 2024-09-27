package com.wjoansah.ex3integrationtesting.inventory.orders;

import org.springframework.stereotype.Component;

@Component
public class MockPaymentGateway implements PaymentGateway {

    @Override
    public boolean processPayment(String paymentDetails, double amount) {
        // Mock successful payment
        return true;
    }
}
