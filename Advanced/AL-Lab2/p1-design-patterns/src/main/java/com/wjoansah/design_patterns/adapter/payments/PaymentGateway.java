package com.wjoansah.design_patterns.adapter.payments;

// Modern Payment Gateway API
public interface PaymentGateway {
    boolean authorizePayment(double amount, String currency);
    boolean capturePayment(String transactionId, double amount);
    boolean refundPayment(String transactionId, double amount);
}
