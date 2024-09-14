package com.wjoansah.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Publisher {
    private final List<Observer> observers;
    private float temperature;
    private float humidity;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void onTemperatureChange() {
        temperature = (float) Math.random() * 50;
        notifyObservers();
    }

    public void onHumidityChange() {
        humidity = (float) Math.random() * 100;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }
}
