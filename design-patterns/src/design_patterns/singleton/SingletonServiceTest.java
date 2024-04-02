package design_patterns.singleton;

public class SingletonServiceTest {
    public static void main(String[] args) {

        System.out.println(SingletonService.getInstance());

        SingletonService.printText();
    }
}
