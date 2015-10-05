package jackfrosch.java8.demo.streams;

public class FunctionalExample {

    public static void main(String[] args) {
        Order order = OrderFactory.createOrder2();

        long start = System.currentTimeMillis();

        System.out.println("Non-taxable total: " + order.calculateNontaxableTotal());
        System.out.println("Taxable total: " + order.calculateTaxableTotal());
        System.out.println("Tax: " + order.calculateTax());
        System.out.println("Order total: " + order.calculateTotal());

        System.out.println("Total time (secs): " + (System.currentTimeMillis() - start) / 1000.0);
    }
}