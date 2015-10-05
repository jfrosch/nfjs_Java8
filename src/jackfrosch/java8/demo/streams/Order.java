package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Order {
    private String orderId;
    private LocalDate orderDate;
    private BigDecimal taxRate;

    private final List<LineItem> lineItems;

    Order(String orderId, LocalDate orderDate, BigDecimal taxRate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.taxRate = taxRate;

        lineItems = new ArrayList<>();
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

    BigDecimal calculateTax() {
        return calculateTaxableTotal().multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_EVEN);
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

    BigDecimal calculateTotal() {
        return calculateNontaxableTotal().add(calculateTaxableTotal().add(calculateTax()));
    }

    void addLineItem(LineItem item) { lineItems.add(item); }
    List<LineItem> getLineItems() { return lineItems; }
    LocalDate getOrderDate() { return orderDate; }
    String getOrderId() { return orderId; }
}
