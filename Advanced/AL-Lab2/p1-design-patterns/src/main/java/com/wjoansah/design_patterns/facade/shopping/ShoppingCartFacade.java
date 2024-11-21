package com.wjoansah.design_patterns.facade.shopping;

public class ShoppingCartFacade {
    private final InventorySystem inventorySystem;
    private final DiscountSystem discountSystem;
    private final PaymentSystem paymentSystem;
    private final CartSystem cartSystem;

    public ShoppingCartFacade() {
        this.inventorySystem = new InventorySystem();
        this.discountSystem = new DiscountSystem();
        this.paymentSystem = new PaymentSystem();
        this.cartSystem = new CartSystem();
    }

    public void addItemToCart(String itemId, double price, String promoCode) {
        if (!inventorySystem.isInStock(itemId)) {
            System.out.println("Item " + itemId + " is out of stock!");
            return;
        }

        // Calculate discount
        double itemDiscount = discountSystem.calculateDiscount(itemId);
        double promoDiscount = discountSystem.applyPromoCode(promoCode);
        double discount = Math.max(itemDiscount, promoDiscount); // Use max discount available

        double discountedPrice = price * (1 - discount);

        // Add item to cart
        cartSystem.addItem(itemId, discountedPrice);

        // Reduce stock
        inventorySystem.reduceStock(itemId);
    }

    public boolean checkout() {
        double totalAmount = cartSystem.getTotalAmount();
        if (totalAmount <= 0) {
            System.out.println("Cart is empty, cannot proceed to checkout.");
            return false;
        }

        // Process payment
        boolean paymentSuccess = paymentSystem.processPayment(totalAmount);
        if (paymentSuccess) {
            System.out.println("Checkout successful. Thank you for your purchase!");
            cartSystem.clearCart();
            return true;
        } else {
            System.out.println("Payment failed. Please try again.");
            return false;
        }
    }
}
