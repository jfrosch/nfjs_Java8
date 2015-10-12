package jackfrosch.java8.demo.functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalVsImperativeNumberPicker {

    static Predicate<Integer> evenPicker = new Predicate<Integer>() {
        @Override
        public boolean test(Integer value) {
            return value % 2 == 0;
        }
    };

    static Predicate<Integer> oddPicker = new Predicate<Integer>() {
        @Override
        public boolean test(Integer value) {
            return value % 2 != 0;
        }
    };

    public List<Integer> pickSome(List<Integer> values,
                                  Predicate<Integer> pickingStrategy) {

        List<Integer> results = new ArrayList<>();
        for(Integer candidate: values) {
            if(pickingStrategy.test(candidate)) {
                results.add(candidate);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        FunctionalVsImperativeNumberPicker picker = new FunctionalVsImperativeNumberPicker();

        List<Integer> oddNumbers = picker.pickSome(values, oddPicker);
        List<Integer> evenNumbers = picker.pickSome(values, evenPicker);

        System.out.println("Odd numbers picked with Anon Inner Class: " + oddNumbers);
        System.out.println("Even numbers picked with Anon Inner Class: " + evenNumbers);

        oddNumbers = picker.pickSome(values, value -> value % 2 != 0);
        evenNumbers = picker.pickSome(values, value -> value % 2 == 0);

        System.out.println("Odd numbers picked with lambda: " + oddNumbers);
        System.out.println("Even numbers picked with lambda: " + evenNumbers);

    }

}
