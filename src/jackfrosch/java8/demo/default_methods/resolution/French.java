package jackfrosch.java8.demo.default_methods.resolution;

public interface French extends Greetable {
    default void greet() {
        System.out.println("Bonjour");
    }
}
