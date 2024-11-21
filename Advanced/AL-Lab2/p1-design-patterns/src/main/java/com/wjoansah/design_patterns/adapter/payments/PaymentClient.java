package com.wjoansah.design_patterns.adapter.payments;

public class PaymentClient {
    public static void main(String[] args) {
        LegacyPaymentProcessor legacyProcessor = new LegacyPaymentProcessor();
        PaymentGateway paymentGateway = new LegacyPaymentAdapter(legacyProcessor);

        // Use the modern interface, which is internally adapted to the legacy processor.
        paymentGateway.authorizePayment(100.0, "USD");
        paymentGateway.capturePayment("TXN12345", 100.0);
        paymentGateway.refundPayment("TXN12345", 50.0);
    }
}
