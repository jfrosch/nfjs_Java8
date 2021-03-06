package jackfrosch.java8.demo.streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyEvalExample {
    private static int inTheZone;

    static Integer map(final Integer val) {
        System.out.println("Transforming " + val + "...");
        return val * val;
    }

    private static boolean filter(final Integer val) {
        System.out.print("Filtering " + val + "... ");
        boolean filtered = val >= inTheZone - 5 && val % 5 == 0;
        System.out.println(filtered ? "Included" : "Skipped");

        return filtered;
    }

    public static void main(String[] args) {
        inTheZone = new Random().nextInt(100);

        System.out.println("The inTheZone value: " + inTheZone);

        Stream<Integer> values = IntStream.rangeClosed(1, 100).boxed();
        Stream<Integer> partiallyProcessed = values.filter(LazyEvalExample::filter)
                                                    .map(LazyEvalExample::map);

        System.out.println("We've prepared to filter and map transform the values...");
        System.out.println("... now find and transform upon executing the terminal method");
        int firstFoundSquare = partiallyProcessed.findFirst().get();

        System.out.println("The square of the first found value " + firstFoundSquare);
    }
}
