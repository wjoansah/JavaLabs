package com.wjoansah.design_patterns.decorator;

public class TransparentShapeDecorator extends ShapeDecorator {
    private final double transparency;

    public TransparentShapeDecorator(Shape decoratedShape, double transparency) {
        super(decoratedShape);
        this.transparency = transparency;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setTransparency(transparency);
    }

    private void setTransparency(double transparency) {
        System.out.println("Setting transparency to " + (transparency * 100) + "% for the shape.");
    }
}
