package com.wjoansah.ex3integrationtesting.inventory.orders;

public interface PaymentGateway {
    boolean processPayment(String paymentDetails, double amount);
}
