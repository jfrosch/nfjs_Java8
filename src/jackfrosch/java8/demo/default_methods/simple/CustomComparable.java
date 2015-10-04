package jackfrosch.java8.demo.default_methods.simple;

public interface CustomComparable<T> extends Comparable<T> {

    // This is contrived!!! From JavaDoc for Comparable:
    //   "It is strongly recommended (though not required) that
    //    natural orderings be consistent with equals."
    default boolean isComparativelyEqual(T o) {
        return compareTo(o) == 0;
    }

}
