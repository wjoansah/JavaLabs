package com.wjoansah.design_patterns.observer.stocks;

import com.wjoansah.design_patterns.observer.Observer;

public class Application {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        // Add stocks to the market
        stockMarket.addStock("AAPL", 150.0);
        stockMarket.addStock("GOOGL", 2800.0);

        // Create observers (subscribers)
        Observer user1 = new StockPriceMonitor("User 1");
        Observer user2 = new StockPriceMonitor("User 2");

        // Subscribe to stocks
        stockMarket.subscribe("AAPL", user1);
        stockMarket.subscribe("AAPL", user2);
        stockMarket.subscribe("GOOGL", user1);

        // Update stock prices
        stockMarket.updateStockPrice("AAPL", 155.0);  // Both User 1 and User 2 will be notified
        stockMarket.updateStockPrice("GOOGL", 2850.0); // Only User 1 will be notified
    }
}
