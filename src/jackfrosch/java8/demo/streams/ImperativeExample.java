package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;

public class ImperativeExample {

    public static void main(String[] args) {
        Order order = OrderFactory.createOrder();
        System.out.println("Non-taxable total: " + order.calculateNontaxableTotal());
        System.out.println("Taxable total: " + order.calculateTaxableTotal());
        System.out.println("Tax: " + order.calculateTax());
        System.out.println("Order total: " + order.calculateTotal());
    }
}