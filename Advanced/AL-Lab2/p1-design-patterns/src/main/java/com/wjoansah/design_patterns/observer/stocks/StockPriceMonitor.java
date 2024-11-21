package com.wjoansah.design_patterns.observer.stocks;

import com.wjoansah.design_patterns.observer.Observer;

public class StockPriceMonitor implements Observer {
    private final String name;

    public StockPriceMonitor(String name) {
        this.name = name;
    }

    @Override
    public void update(Object args) {
        Stock stock = (Stock) args;
        System.out.println(name + " notified: " + stock.getSymbol() + " price updated to " + stock.getPrice());
    }
}
