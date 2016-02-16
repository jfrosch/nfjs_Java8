package jackfrosch.java8.demo.method_ref;

import java.time.LocalTime;
import java.util.function.Function;

public class CtorReferenceDemo3 {
    @FunctionalInterface
    private static interface FooFactory<String, LocalTime> {
        Foo create(String msg, LocalTime time);
    }
    private static class Foo {
        static int instanceCount;
        private Foo() { instanceCount++; }
        private Foo(String msg, LocalTime now) {
            this();
            System.out.println(msg + " - " + now + ": " + instanceCount);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            FooFactory<String, LocalTime> factory = Foo::new;
            factory.create("Hello", LocalTime.now());
            Thread.sleep(500);
        }
    }
}
