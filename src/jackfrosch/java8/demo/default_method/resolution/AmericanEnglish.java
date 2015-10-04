package jackfrosch.java8.demo.default_method.resolution;

public interface AmericanEnglish extends English {
    @Override
    default void greet() {
        System.out.println("Hi");
    }
}
