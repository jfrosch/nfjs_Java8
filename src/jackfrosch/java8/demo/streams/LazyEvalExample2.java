package jackfrosch.java8.demo.streams;

import java.util.Collection;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyEvalExample2 {
    private static int inTheZone;

    private static Integer map(final Integer val) {
        System.out.println("Transforming " + val + "...");
        return val * val;
    }

    private static boolean filter1(final Integer val) {
        System.out.print("Filter 1: Filtering " + val + "... ");
        boolean filtered = val >= inTheZone - 5 && val <= inTheZone + 5;
        System.out.println(filtered ? "Included" : "Skipped");

        return filtered;
    }

    private static boolean filter2(final Integer val) {
        System.out.print("Filter 2: Filtering " + val + "... ");
        boolean filtered = val % 3 == 0;
        System.out.println(filtered ? "Included" : "Skipped");

        return filtered;
    }

    private static Integer terminate(Stream<Integer> values) {
        return values.findFirst().get();
//        return values.reduce(0, (Integer a, Integer b) -> a + b);
    }

    public static void main(String[] args) {
        inTheZone = 21;

        System.out.println("The inTheZone value: " + inTheZone);

        Stream<Integer> values = IntStream.rangeClosed(1, 25).boxed();
        Stream<Integer> lazilyProcessed = values.filter(LazyEvalExample2::filter1)
                                                .filter(LazyEvalExample2::filter2)
                                                .map(LazyEvalExample2::map);

        System.out.println("We've prepared to filter and map transform the values...");
        System.out.println("... now find and transform upon executing the terminal method");
        int sumOfSquares = terminate(lazilyProcessed);

        System.out.println("The sum of squares in the zone: " + sumOfSquares);
    }
}