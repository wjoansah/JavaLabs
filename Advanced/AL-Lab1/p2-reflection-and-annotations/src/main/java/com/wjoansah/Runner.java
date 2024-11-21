package com.wjoansah;

public class Runner {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        ExecutionTimeLogger.logExecutionTime(App.class, "sayHello");
    }
}
