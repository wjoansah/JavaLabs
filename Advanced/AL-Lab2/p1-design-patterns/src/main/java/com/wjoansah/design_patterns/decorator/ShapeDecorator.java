package com.wjoansah.design_patterns.decorator;

public abstract class ShapeDecorator implements Shape {
    protected final Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
