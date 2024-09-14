package com.wjoansah.abstract_factory;

public class LinuxButton implements Button {

    @Override
    public void render() {
        System.out.println("rendering button on Linux");
    }
}
