package com.wjoansah;

public class App {
    public static void main(String[] args) {
        MovieRecommendationEngine engine = new MovieRecommendationEngine();
        engine.run("./data.csv");
    }
}
