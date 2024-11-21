package com.wjoansah;

public class App {
    @LogExecutionTime
    public static void sayHello(String name) {
        System.out.printf("Hello, %s!\n", name);
    }

    @LogExecutionTime
    public static void sayHello() {
        System.out.println("Hello, world!");
    }
}
