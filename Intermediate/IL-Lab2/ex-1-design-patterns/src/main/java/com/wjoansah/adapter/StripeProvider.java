package com.wjoansah.adapter;

public class StripeProvider implements ModernPaymentProvider {
    @Override
    public void processPayment(String sourceAccount, String destinationAccount, double amount, String paymentType) {
        System.out.println("making payment of " + amount + " from " + sourceAccount + " to " + destinationAccount + " using " + paymentType);
    }
}
