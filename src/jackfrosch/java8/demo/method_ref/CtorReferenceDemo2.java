package jackfrosch.java8.demo.method_ref;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Function;

public class CtorReferenceDemo2 {
    private static class Foo {

        static int instanceCount;

        private Foo() {
            instanceCount++;
        }

        private Foo(LocalTime now) {
            this();
            System.out.println(now + ": " + instanceCount);
        }

        static Foo create(LocalTime now, Function<LocalTime, Foo> function) {
            return function.apply(now);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Foo foo = Foo.create(LocalTime.now(), Foo::new); // Function<LocalTime, Foo>
            Thread.sleep(500);
        }
    }
}
