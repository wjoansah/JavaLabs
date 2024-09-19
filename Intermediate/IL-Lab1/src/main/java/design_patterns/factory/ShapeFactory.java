package design_patterns.factory;

public class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("circle"))
            return new Circle();
        if (shapeType.equalsIgnoreCase("square"))
            return new Square();

        throw new RuntimeException("Shape type not recognized");
    }

    public static void main(String[] args) {
        var circle = (Circle) ShapeFactory.getShape("Circle");
        var square = ShapeFactory.getShape("Square");
        System.out.println("circle area: " + circle.area());
        System.out.println("square area: " + square.area());
    }
}
