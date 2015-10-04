package jackfrosch.java8.demo;

public interface CustomComparable<T> extends Comparable<T> {

    default boolean isComparativelyEqual(T o) {
        return compareTo(o) == 0;
    }

}
