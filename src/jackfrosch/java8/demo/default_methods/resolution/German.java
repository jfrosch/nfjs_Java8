package jackfrosch.java8.demo.default_methods.resolution;

public interface German extends Greetable {
    default void greet() {
        System.out.println("Guten Tag");
    }
}
