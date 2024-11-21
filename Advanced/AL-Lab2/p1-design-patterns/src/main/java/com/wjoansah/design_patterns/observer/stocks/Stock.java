package com.wjoansah.design_patterns.observer.stocks;

import com.wjoansah.design_patterns.observer.Observer;
import com.wjoansah.design_patterns.observer.Publisher;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Publisher {
    private final List<Observer> observers = new ArrayList<>();
    private final String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (this.price != newPrice) {
            this.price = newPrice;
            notifyObservers();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
}
