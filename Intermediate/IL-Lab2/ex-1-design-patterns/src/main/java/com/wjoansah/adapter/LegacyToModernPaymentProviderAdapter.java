package com.wjoansah.adapter;

public class LegacyToModernPaymentProviderAdapter implements ModernPaymentProvider {
    private final LegacyPaymentProvider legacyPaymentProvider;

    public LegacyToModernPaymentProviderAdapter() {
        this.legacyPaymentProvider = new LegacyPaymentProvider();
    }

    @Override
    public void processPayment(String sourceAccount, String destinationAccount, double amount, String paymentType) {
        legacyPaymentProvider.transfer(sourceAccount, destinationAccount, (int) amount);
    }
}
