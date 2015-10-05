package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

public class Order2 extends Order {
    Order2(String orderId, LocalDate orderDate, BigDecimal taxRate) {
        super(orderId, orderDate, taxRate);
    }

    @Override
    public BigDecimal calculateTaxableTotal() {
        return getStream().filter(LineItem::isTaxable)
                          .map(LineItem::calculateTotal)
                          .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal calculateNontaxableTotal() {
        return getStream().filter(item -> !item.isTaxable())
                          .map(LineItem::calculateTotal)
                          .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Stream<LineItem> getStream() {
        return lineItems.stream();
    }
}
