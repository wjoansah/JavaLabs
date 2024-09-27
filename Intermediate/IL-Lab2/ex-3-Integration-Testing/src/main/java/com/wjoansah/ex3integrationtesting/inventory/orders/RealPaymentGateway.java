package com.wjoansah.ex3integrationtesting.inventory.orders;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("RealPaymentGateway")
public class RealPaymentGateway implements PaymentGateway {

    @Override
    public boolean processPayment(String paymentDetails, double amount) {
        // Simulate real payment processing, e.g., calling a third-party API
        // For now, return true for simplicity
        return true;
    }
}
