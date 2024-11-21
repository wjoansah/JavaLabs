package com.wjoansah.design_patterns.template.orders;

public class IntlOrderProcessor extends OrderProcessor {
    @Override
    protected void selectItem() {
        System.out.println("Selecting item for an international order.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Processing payment for an international order.");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Shipping order internationally.");
    }

    // Override hook method to indicate international processing
    @Override
    protected boolean isInternationalOrder() {
        return true;
    }
}
