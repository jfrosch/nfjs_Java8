package jackfrosch.java8.demo.default_methods.resolution;

public interface AmericanEnglish extends English {
    @Override
    default void greet() {
        System.out.println("Hi");
    }

    // This is needed to unhide the English greeting
    default void greetFormalEnglish() {
        English.super.greet();
    }
}
