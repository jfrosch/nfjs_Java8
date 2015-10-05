package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderFactory {
    static Order createOrder() {
        Order order = new Order("Order 1", LocalDate.now(), new BigDecimal("0.05"));

        order.addLineItem(new LineItem(order, "Radio", 1, new BigDecimal("100.00"), true));
        order.addLineItem(new LineItem(order, "Book", 2, new BigDecimal("15.00"), true));
        order.addLineItem(new LineItem(order, "DVD", 1, new BigDecimal("10.00"), true));
        order.addLineItem(new LineItem(order, "Milk", 1, new BigDecimal("3.50"), false));
        order.addLineItem(new LineItem(order, "Fruit", 5, new BigDecimal("3.00"), false));
        order.addLineItem(new LineItem(order, "Alcohol", 5, new BigDecimal("20.00"), true));
        order.addLineItem(new LineItem(order, "Cereal", 3, new BigDecimal("5.00"), false));
        order.addLineItem(new LineItem(order, "Soup", 10, new BigDecimal("1.00"), false));
        order.addLineItem(new LineItem(order, "Bread", 2, new BigDecimal("3.00"), false));
        order.addLineItem(new LineItem(order, "Eggs", 2, new BigDecimal("2.50"), false));
        return order;
    }
}
