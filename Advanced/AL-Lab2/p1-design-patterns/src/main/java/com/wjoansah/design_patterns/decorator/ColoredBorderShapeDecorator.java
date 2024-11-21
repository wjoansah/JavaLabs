package com.wjoansah.design_patterns.decorator;

public class ColoredBorderShapeDecorator extends ShapeDecorator {
    private final String borderColor;

    public ColoredBorderShapeDecorator(Shape decoratedShape, String borderColor) {
        super(decoratedShape);
        this.borderColor = borderColor;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setBorderColor(borderColor);
    }

    private void setBorderColor(String color) {
        System.out.println("Adding a " + color + " border to the shape.");
    }
}
