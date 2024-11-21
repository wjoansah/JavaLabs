package com.wjoansah.design_patterns.observer.weather_station;

import com.wjoansah.design_patterns.observer.Observer;
import com.wjoansah.design_patterns.observer.Publisher;

public class TemperatureDisplay implements Observer {
    private Publisher weatherStation;
    private float temperature;

    public TemperatureDisplay(Publisher weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerObserver(this);
    }

    public void render() {
        System.out.println("current temperature: " + temperature + " degrees");
    }

    @Override
    public void update(Object args) {
        WeatherStation weatherStation = (WeatherStation) args;
        temperature = weatherStation.getTemperature();
    }
}
