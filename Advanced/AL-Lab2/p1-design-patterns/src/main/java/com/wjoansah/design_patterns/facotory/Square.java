package com.wjoansah.design_patterns.facotory;

public class Square implements Shape {
    private double side;

    public Square() {
        this.side = 1;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
