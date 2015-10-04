package jackfrosch.java8.demo.default_methods.resolution;

public interface AmericanEnglish extends English {
    @Override
    default void greet() {
        System.out.println("Hi");
    }
}
