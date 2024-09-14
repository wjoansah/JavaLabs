package com.wjoansah.adapter;

public interface ModernPaymentProvider {
    void processPayment(String sourceAccount, String destinationAccount, double amount, String paymentType);
}
