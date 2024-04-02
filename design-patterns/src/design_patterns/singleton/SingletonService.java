package design_patterns.singleton;

public class SingletonService {
    /**
     * TODO Steps to create a singleton class:
     * 1. create a private constructor
     * 2. declare a private static final (constant) variable of this type and assign an object instantiated using private constructor from step 1
     * 3. create a public static method called "getInstance" that returns the static variable from step 2

     * Great job! Now you have a singleton class. Let put this at work.

     * TODO
     * 1. Create a public method that prints a String with text "Design patterns are fun".
     * 2. In the same package, create a class called SingletonServiceTest, declare a main method, get an instance of SingletonService and call method from above step.
     */

    private static final SingletonService singletonInstance = new SingletonService();

    private SingletonService() {}

    public static SingletonService getInstance() {
        return singletonInstance;
    }

    public static void printText() {
        System.out.println("Design patterns are fun");
    }
}
