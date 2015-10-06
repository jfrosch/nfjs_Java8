package jackfrosch.java8.demo.streams;

public class ImperativeExample {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Order order = OrderFactory.createOrder();
        System.out.println("Non-taxable total: " + order.calculateNontaxableTotal());
        System.out.println("Taxable total: " + order.calculateTaxableTotal());
        System.out.println("Tax: " + order.calculateTax());
        System.out.println("Order total: " + order.calculateTotal());

        System.out.println("Total time (secs): " + (System.currentTimeMillis() - start) / 1000.0);
    }
}