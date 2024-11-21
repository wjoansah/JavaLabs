package com.wjoansah.design_patterns.observer.stocks;

import com.wjoansah.design_patterns.observer.Observer;

import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private final Map<String, Stock> stocks = new HashMap<>();

    public void addStock(String symbol, double price) {
        stocks.put(symbol, new Stock(symbol, price));
    }

    public void subscribe(String symbol, Observer observer) {
        Stock stock = stocks.get(symbol);
        if (stock != null) {
            stock.registerObserver(observer);
        }
    }

//    public void unsubscribe(String symbol, Observer observer) {
//        Stock stock = stocks.get(symbol);
//        if (stock != null) {
//            stock.removeObserver(observer);
//        }
//    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = stocks.get(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
        }
    }
}
