package com.wjoansah.abstract_factory;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("rendering a button on Windows");
    }
}
