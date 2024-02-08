// Parent class (Superclass)
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

// Child class (Subclass) inheriting from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// Preventing inheritance using final keyword
final class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing...");
    }
}

// Abstract class
abstract class Shape {
    abstract void draw(); // Abstract method
}

// Concrete subclass inheriting from abstract class
class Circle extends Shape {
    void draw() {
        System.out.println("Circle is drawn...");
    }
}

public class Main1 {
    public static void main(String[] args) {
        // Using inheritance
        Dog dog = new Dog();
        dog.eat(); // Inherited from Animal
        dog.bark();

        // Using final class (cannot be extended)
        Cat cat = new Cat();
        cat.eat(); // Inherited from Animal
        cat.meow();

        // Using abstract class
        Shape shape = new Circle();
        shape.draw(); // Implemented in Circle class
    }
}
