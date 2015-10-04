package jackfrosch.java8.demo.default_method.resolution;

public interface French extends Greetable {
    default void greet() {
        System.out.println("Bonjour");
    }
}
