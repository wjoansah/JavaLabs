package com.wjoansah.design_patterns.singleton;

public class Logger {
    public static Logger instance;
    public static Logger getLogger() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();

        logger.log("Hello World");
    }
}
