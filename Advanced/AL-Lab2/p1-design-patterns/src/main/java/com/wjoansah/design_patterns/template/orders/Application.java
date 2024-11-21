package com.wjoansah.design_patterns.template.orders;

public class Application {
    public static void main(String[] args) {

        System.out.println("Domestic Order:");
        OrderProcessor domesticOrder = new DomesticOrderProcessor();
        domesticOrder.processOrder();

        System.out.println("\nInternational Order:");
        OrderProcessor internationalOrder = new IntlOrderProcessor();
        internationalOrder.processOrder();
    }
}

