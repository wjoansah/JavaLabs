package com.wjoansah.design_patterns.facotory;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }
        throw new RuntimeException("Shape type not recognized");
    }
}
