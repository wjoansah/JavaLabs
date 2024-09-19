package design_patterns.factory;

public class Circle implements Shape {
    private int radius;

    public Circle() {
        this(1);
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        var circle = new Circle(5);

        System.out.println(circle.area());
        circle.setRadius(7);
        System.out.println(circle.area());
    }

}
