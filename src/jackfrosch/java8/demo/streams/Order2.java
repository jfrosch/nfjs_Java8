package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order2 extends Order {
    Order2(String orderId, LocalDate orderDate, BigDecimal taxRate) {
        super(orderId, orderDate, taxRate);
    }

    @Override
    public BigDecimal calculateTaxableTotal() {
        return super.calculateTaxableTotal();
    }

    @Override
    public BigDecimal calculateTax() {
        return super.calculateTax();
    }

    @Override
    public BigDecimal calculateNontaxableTotal() {
        return super.calculateNontaxableTotal();
    }

    @Override
    public BigDecimal calculateTotal() {
        return super.calculateTotal();
    }
}
