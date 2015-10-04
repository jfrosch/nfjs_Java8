package jackfrosch.java8.demo.method_ref;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Barb", "Bob", "Sarah", "Steve");

        System.out.println("Using lambda");
        names.forEach(name -> System.out.println(name));


        System.out.println("\nUsing method reference, with stream");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);

    }
}
