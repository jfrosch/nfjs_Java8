package jackfrosch.java8.demo.default_methods.resolution;

public interface English extends Greetable {
    default void greet() {
        System.out.println("Hello");
    }
}
