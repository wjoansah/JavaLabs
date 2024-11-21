package com.wjoansah.design_patterns.facade.shopping;

public class Application {
    public static void main(String[] args) {
        ShoppingCartFacade shoppingCart = new ShoppingCartFacade();

        System.out.println("Adding items to cart:");
        shoppingCart.addItemToCart("ItemA", 50.0, "PROMO10");  // With promo code
        shoppingCart.addItemToCart("ItemB", 30.0, "");          // No promo code

        System.out.println("\nChecking out:");
        shoppingCart.checkout();
    }
}
