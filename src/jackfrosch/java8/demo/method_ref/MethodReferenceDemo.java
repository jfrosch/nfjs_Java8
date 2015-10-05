package jackfrosch.java8.demo.method_ref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Barb", "Bob", "Sarah", "Steve");

        System.out.println("Using lambda");
        names.forEach(name -> System.out.println(name));


        System.out.println("\nLet's imperatively transform the collection");
        System.out.println("Then use method reference to print them out...");

        List<String> transformedValues = new ArrayList<String>();
        names.forEach(name -> transformedValues.add(name.toUpperCase()));
        transformedValues.forEach(System.out::println);
    }
}
