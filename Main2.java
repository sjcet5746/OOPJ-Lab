// Parent class
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    // Method overriding
    void sound() {
        System.out.println("Dog barks");
    }

    // Method overloading
    void sound(String type) {
        System.out.println("Dog barks " + type);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Animal animal = new Animal(); // Parent class reference to child class object
        Dog dog = new Dog(); // Child class object

        // Dynamic binding - calls overridden method of Dog class
        animal.sound(); // Output: Animal makes a sound
        dog.sound(); // Output: Dog barks

        // Method overloading
        dog.sound("loudly"); // Output: Dog barks loudly
    }
}
