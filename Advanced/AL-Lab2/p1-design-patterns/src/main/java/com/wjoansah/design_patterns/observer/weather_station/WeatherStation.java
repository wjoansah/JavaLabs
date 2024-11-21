package com.wjoansah.design_patterns.observer.weather_station;

import com.wjoansah.design_patterns.observer.Observer;
import com.wjoansah.design_patterns.observer.Publisher;

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

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay tempDisplay = new TemperatureDisplay(weatherStation);
        HumidityDisplay humidityDisplay = new HumidityDisplay(weatherStation);

        try {
            for (int i = 0; i < 10; i++) {
                weatherStation.onTemperatureChange();
                weatherStation.onHumidityChange();
                Thread.sleep(500);
                System.out.println("-------------------------------");
                tempDisplay.render();
                humidityDisplay.render();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
