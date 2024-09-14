package com.wjoansah.factory;

public class Square implements Shape {
    private int breadth;
    private int length;

    public Square() {
        this(1);
    }

    public Square(int breadth) {
        this.breadth = breadth;
        this.length = breadth;
    }

    @Override
    public double area() {
        return breadth * length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static void main(String[] args) {
        var square = new Square(5);
        System.out.println(square.area());
    }
}
