package com.wjoansah.observer;

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
        var weatherStation = (WeatherStation) args;
        humidity = weatherStation.getHumidity();
    }
}
