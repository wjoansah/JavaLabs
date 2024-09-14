package com.wjoansah.facade;

public class OrderFacade {
    private final InventoryManager inventoryManager;
    private final PaymentProcessor paymentProcessor;
    private final OrderFulfillment orderFulfillment;

    public OrderFacade() {
        inventoryManager = new InventoryManager();
        paymentProcessor = new PaymentProcessor();
        orderFulfillment = new OrderFulfillment();
    }

    public void placeOrder(String item, String paymentType, double amount) {
        inventoryManager.checkInventory(item);
        paymentProcessor.processPayment(paymentType, amount);
        orderFulfillment.fulfillOrder(item);
        System.out.println("Order placed successfully for " + item);
    }

    public static void main(String[] args) {
        var orderFacade = new OrderFacade();
        orderFacade.placeOrder("batman 1968 comic book", "card", 10.0d);
    }
}


class InventoryManager {
    public void checkInventory(String item) {
        System.out.println("Checking inventory for " + item);
    }
}

class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        System.out.println("Processing " + paymentType + " payment of $" + amount);
    }
}

class OrderFulfillment {
    public void fulfillOrder(String item) {
        System.out.println("Fulfilling order for " + item);
    }
}
