package jackfrosch.java8.demo.method_ref;

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
        for(int i = 0; i < 10; i++) {
            Foo foo = Foo.create(Foo::new); // Foo:new returns Supplier<Foo>
            System.out.println(foo.instanceCount);
        }
    }
}
