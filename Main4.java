// Abstract class Shape
abstract class Shape {
    protected int dimension1;
    protected int dimension2;

    public Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    // Abstract method to calculate and print area
    abstract void printArea();
}

// Rectangle class extending Shape
class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class extending Shape
class Triangle extends Shape {
    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class extending Shape
class Circle extends Shape {
    public Circle(int radius) {
        super(radius, radius); // Considering radius as both dimensions for a circle
    }

    @Override
    void printArea() {
        double area = Math.PI * dimension1 * dimension2;
        System.out.println("Area of Circle: " + area);
    }
}

public class Main4 {
    public static void main(String[] args) {
        // Creating objects of different shapes
        Rectangle rectangle = new Rectangle(5, 4);
        Triangle triangle = new Triangle(6, 3);
        Circle circle = new Circle(7);

        // Printing areas
        rectangle.printArea(); // Output: Area of Rectangle: 20
        triangle.printArea(); // Output: Area of Triangle: 9.0
        circle.printArea(); // Output: Area of Circle: 153.93804002589985
    }
}
