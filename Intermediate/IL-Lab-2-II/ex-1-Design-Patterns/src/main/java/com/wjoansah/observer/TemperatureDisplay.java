package com.wjoansah.observer;

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
        var weatherStation = (WeatherStation) args;
        temperature = weatherStation.getTemperature();
    }
}
