package com.wjoansah.design_patterns.adapter.payments;


// Legacy Payment Processor (simulated, legacy code)
public class LegacyPaymentProcessor {
    public boolean makePayment(double amount) {
        System.out.println("Processing payment of " + amount + " using Legacy Processor.");
        return true;
    }

    public boolean voidPayment(String txnId) {
        System.out.println("Voiding payment with transaction ID: " + txnId + " using Legacy Processor.");
        return true;
    }

    public boolean refund(double amount) {
        System.out.println("Refunding amount " + amount + " using Legacy Processor.");
        return true;
    }
}
