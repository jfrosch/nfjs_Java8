package jackfrosch.java8.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyEvalExample {

    private static int square(int value) {
        System.out.println("Calculating square for " + value);
        return value * value;
    }

    public static void main(String[] args) {
        int inTheZone = new Random().nextInt(1000);

        System.out.println("The inTheZone value: " + inTheZone);

        Stream<Integer> values = IntStream.rangeClosed(1, 1000).boxed();

        Predicate<Integer> filter = val -> val >= inTheZone - 5 && val <= inTheZone + 5 && val % 7 == 0;
        Stream<Integer> partiallyProcessed = values.filter(filter)
                                                    .map(LazyEvalExample::square);

        System.out.println("We've filtered and mapped the values...");
        System.out.println("... now print the square of the first found when the terminal operation hit");
        int firstFoundSquare = partiallyProcessed.findFirst().get();

        System.out.println("The square of the first found value " + firstFoundSquare);
    }
}
