package com.wjoansah.adapter;

public class LegacyPaymentProvider {
    public void transfer(String sourceAccount, String destinationAccount, int amount) {
        System.out.println("transferring " + amount + " from " + sourceAccount + " to " + destinationAccount);
    }
}
