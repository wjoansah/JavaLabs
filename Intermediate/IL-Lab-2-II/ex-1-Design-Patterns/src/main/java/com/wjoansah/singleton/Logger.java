package com.wjoansah.singleton;

public class Logger {
    private static Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        var logger = Logger.getInstance();

        logger.log("logging with new logger singleton");
        System.out.println(logger.hashCode());

        var logger2 = Logger.getInstance();
        System.out.println(logger2.hashCode());
    }
}
