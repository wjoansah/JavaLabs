package com.wjoansah.design_patterns.decorator;

public class Application {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redBorderCircle = new ColoredBorderShapeDecorator(circle, "Red");
        Shape transparentSquare = new TransparentShapeDecorator(new Square(), 0.5);
        Shape customShape = new TransparentShapeDecorator(redBorderCircle, 0.8);

        System.out.println("Basic Circle:");
        circle.draw();

        System.out.println("\nCircle with Red Border:");
        redBorderCircle.draw();

        System.out.println("\nTransparent Rectangle:");
        transparentSquare.draw();

        System.out.println("\nCircle with Red Border and 80% Transparency:");
        customShape.draw();
    }
}
