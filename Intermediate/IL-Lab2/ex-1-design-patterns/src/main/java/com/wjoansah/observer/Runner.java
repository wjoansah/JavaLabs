package com.wjoansah.observer;

public class Runner {
    public static void main(String[] args) {
        var weatherStation = new WeatherStation();
        var tempDisplay = new TemperatureDisplay(weatherStation);
        var humidityDisplay = new HumidityDisplay(weatherStation);

        try {
            for (int i = 0; i < 10; i++) {
                weatherStation.onTemperatureChange();
                weatherStation.onHumidityChange();
                Thread.sleep(500);
                tempDisplay.render();
                humidityDisplay.render();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
