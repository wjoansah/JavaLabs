package com.wjoansah.design_patterns.template.orders;

public class DomesticOrderProcessor extends OrderProcessor {
    @Override
    protected void selectItem() {
        System.out.println("Selecting item for a domestic order.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Processing payment for a domestic order.");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Shipping order domestically.");
    }
}
