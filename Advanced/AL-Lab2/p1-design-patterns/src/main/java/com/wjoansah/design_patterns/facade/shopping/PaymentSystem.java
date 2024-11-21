package com.wjoansah.design_patterns.facade.shopping;

public class PaymentSystem {
    public boolean processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
        return true;
    }
}
