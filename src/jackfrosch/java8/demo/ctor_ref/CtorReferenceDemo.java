package jackfrosch.java8.demo.ctor_ref;

import java.util.function.Supplier;

public class CtorReferenceDemo {
    static class Foo {

        static int instanceCount;
        private Foo() {
            instanceCount++;
        }

        static Foo create(Supplier<Foo> supplier) {
            return supplier.get();
        }
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            Foo.create(Foo::new);
            System.out.println(Foo.instanceCount);
        }
    }
}
