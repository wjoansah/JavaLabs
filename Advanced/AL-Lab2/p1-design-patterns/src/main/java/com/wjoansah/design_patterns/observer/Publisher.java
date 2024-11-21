package com.wjoansah.design_patterns.observer;

public interface Publisher {
    void notifyObservers();
    void registerObserver(Observer observer);
}
