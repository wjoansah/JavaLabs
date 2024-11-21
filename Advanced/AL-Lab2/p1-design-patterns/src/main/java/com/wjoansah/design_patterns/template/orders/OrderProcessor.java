package com.wjoansah.design_patterns.template.orders;

public abstract class OrderProcessor {

    // Template method defining the order of steps
    public final void processOrder() {
        selectItem();
        makePayment();
        if (isInternationalOrder()) {
            calculateInternationalShipping();
        } else {
            calculateDomesticShipping();
        }
        shipOrder();
    }

    protected abstract void selectItem();

    protected abstract void makePayment();

    protected void calculateDomesticShipping() {
        System.out.println("Calculating domestic shipping cost.");
    }

    protected void calculateInternationalShipping() {
        System.out.println("Calculating international shipping cost.");
    }

    protected abstract void shipOrder();

    // Hook method for conditional step
    protected boolean isInternationalOrder() {
        return false;
    }
}
