package jackfrosch.java8.demo;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// starting in 1.5 interfaces could be declared with generics
public class Dog2 implements CustomComparable<Dog2> {
    final String ownerLastName;
    final String name;
    final LocalDate lastVaccination;

    public Dog2(String name, String ownerLastName, LocalDate lastVaccination) {
        this.name = name;
        this.ownerLastName = ownerLastName;
        this.lastVaccination = lastVaccination;
    }

    public String toString() {
        return String.format("%s, %s [Last Vaccination: %s]",
                                ownerLastName, name,
                                lastVaccination.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Override
    public int hashCode() {
        int result = ownerLastName.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastVaccination.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // starting in 1.6 @Override applied to interfaces
    public int compareTo(Dog2 other) {
        int result = ownerLastName.compareTo(other.ownerLastName);
        if (result == 0) {
            result = name.compareTo(other.name);
        }
        return result;
    }

    public static void main(String[] args) {
        Dog2 fido_smith = new Dog2("Fido", "Smith", LocalDate.now());
        Dog2 fido_smith2 = new Dog2("Fido", "Smith", LocalDate.now().minus(3, ChronoUnit.WEEKS));
        Dog2 fluffy_jones = new Dog2("Fluffy", "Jones", LocalDate.of(2015, Month.JULY, 1));
        Dog2 fido_jones = new Dog2("Fido", "Jones", LocalDate.parse("2015-02-28"));

        Dog2[] dogs = { fido_smith, fido_jones, fluffy_jones, fido_smith2 };

        System.out.println("Unsorted:");
        for(Dog2 dog: dogs) {
            System.out.println(dog);
        }

        List<Dog2> dawgs = Arrays.asList(dogs);  // Varargs came along in 1.5
        Collections.sort(dawgs);                // Collections as of 1.5
        System.out.println("\nSorted:");
        for(Dog2 dog: dawgs) {
            System.out.println(dog);
        }

        System.out.println("\nComparatively Equal");
        System.out.println("Are Fido Jones and Fido Smith comparatively equal? " + fido_jones.isComparativelyEqual(fido_smith));
        System.out.println("Are Fido Smith and Fido Smith #2 comparatively equal? " + fido_smith.isComparativelyEqual(fido_smith2));
    }
}
