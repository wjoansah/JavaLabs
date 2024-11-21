package com.wjoansah.design_patterns.observer.weather_station;

import com.wjoansah.design_patterns.observer.Observer;
import com.wjoansah.design_patterns.observer.Publisher;

public class HumidityDisplay implements Observer {
    private float humidity;

    public HumidityDisplay(Publisher weatherStation) {
        weatherStation.registerObserver(this);
    }

    public void render() {
        System.out.println("current humidity: " + humidity + " %");
    }

    @Override
    public void update(Object args) {
        WeatherStation weatherStation = (WeatherStation) args;
        humidity = weatherStation.getHumidity();
    }
}
