package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Order {
    String orderId;
    LocalDate orderDate;
    BigDecimal taxRate;

    final List<LineItem> lineItems = new ArrayList<>();

    Order(String orderId, LocalDate orderDate, BigDecimal taxRate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.taxRate = taxRate;
    }

    BigDecimal calculateTaxableTotal() {
        BigDecimal taxableTotal = BigDecimal.ZERO;

        for(LineItem item: lineItems) {
            if(item.isTaxable()) {
                taxableTotal = taxableTotal.add(item.calculateTotal());
            }
        }
        return taxableTotal;
    }

    BigDecimal calculateNontaxableTotal() {
        BigDecimal nontaxableTotal = BigDecimal.ZERO;

        for(LineItem item: lineItems) {
            if(!item.isTaxable()) {
                nontaxableTotal = nontaxableTotal.add(item.calculateTotal());
            }
        }
        return nontaxableTotal;
    }

    BigDecimal calculateTax() {
        return calculateTaxableTotal().multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    BigDecimal calculateTotal() {
        return calculateNontaxableTotal().add(calculateTaxableTotal().add(calculateTax()));
    }

    void addLineItem(LineItem item) { lineItems.add(item); }
}
