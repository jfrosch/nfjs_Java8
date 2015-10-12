package jackfrosch.java8.demo.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LambdaTestDemo {
    Predicate<Integer> numberPicker;

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Before
    public void setUp() {
        numberPicker = value -> value % 2 != 0;
    }

    @Test
    public void testIsOddNumberLambda() {
        assertTrue("101 is odd", numberPicker.test(101));
    }

    @Test
    public void testOddNumberLambda_YieldsFalseForEvenNumbers() {
        assertFalse("100 is not odd", numberPicker.test(100));
    }

    @Test
    public void testOddNumberPicker() {
        List<Integer> odds = numbers.stream()
                                    .filter(numberPicker)
                                    .collect(Collectors.toList());

        assertEquals(Arrays.asList(1, 3, 5, 7, 9), odds);
    }
}