package com.wjoansah.observer;

public interface Publisher {
    void notifyObservers();
    void registerObserver(Observer o);
}
