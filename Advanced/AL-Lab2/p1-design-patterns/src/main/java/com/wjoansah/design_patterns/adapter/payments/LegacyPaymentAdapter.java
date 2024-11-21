package com.wjoansah.design_patterns.adapter.payments;

public class LegacyPaymentAdapter implements PaymentGateway {
    private final LegacyPaymentProcessor legacyProcessor;

    public LegacyPaymentAdapter(LegacyPaymentProcessor legacyProcessor) {
        this.legacyProcessor = legacyProcessor;
    }

    @Override
    public boolean authorizePayment(double amount, String currency) {
        System.out.println("Adapting authorization...");
        return legacyProcessor.makePayment(amount);
    }

    @Override
    public boolean capturePayment(String transactionId, double amount) {
        System.out.println("Adapting capture (no-op in legacy)...");
        // Legacy processor doesn't support capture, so we assume payment was already processed in `authorizePayment`
        return true;
    }

    @Override
    public boolean refundPayment(String transactionId, double amount) {
        System.out.println("Adapting refund...");
        return legacyProcessor.refund(amount);
    }
}
