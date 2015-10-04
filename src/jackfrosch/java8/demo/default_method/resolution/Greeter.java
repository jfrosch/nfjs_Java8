package jackfrosch.java8.demo.default_method.resolution;

public class Greeter implements AmericanEnglish, French, German {

    // Comment greet() implementation  out to see the compiler complain
    @Override
    public void greet() {
        System.out.println("Howdy");
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.greet();
        greeter.greetInFrench();
        greeter.greetInGerman();
        greeter.greetInAmericanEnglish();

    }

    private void greetInFrench() {
        French.super.greet();
    }

    private void greetInGerman() {
        German.super.greet();
    }

    private void greetInAmericanEnglish() {
        AmericanEnglish.super.greet();
    }
}
