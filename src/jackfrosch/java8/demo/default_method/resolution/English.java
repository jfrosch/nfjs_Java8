package jackfrosch.java8.demo.default_method.resolution;

public interface English extends Greetable {
    default void greet() {
        System.out.println("Hello");
    }
}
