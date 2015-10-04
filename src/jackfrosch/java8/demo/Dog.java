package jackfrosch.java8.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// starting in 1.5 interfaces could be declared with generics
public class Dog implements Comparable<Dog> {
    String ownerLastName;
    String name;

    public Dog(String name, String ownerLastName) {
        this.name = name;
        this.ownerLastName = ownerLastName;
    }

    public String toString() {
        return ownerLastName + ", " + name;
    }

    @Override // starting in 1.6 @Override applied to interfaces
    public int compareTo(Dog other) {
        int result = ownerLastName.compareTo(other.ownerLastName);
        if (result == 0) {
            result = name.compareTo(other.name);
        }
        return result;
    }

    public static void main(String[] args) {
        Dog[] dogs = { new Dog("Fido", "Smith"),
                       new Dog("Fluffy", "Jones"),
                       new Dog("Fido", "Jones") };

        System.out.println("Unsorted:");
        for(Dog dog: dogs) {
            System.out.println(dog);
        }

        List<Dog> dawgs = Arrays.asList(dogs);
        Collections.sort(dawgs);
        System.out.println("\nSorted:");
        for(Dog dog: dawgs) {
            System.out.println(dog);
        }
    }
}
