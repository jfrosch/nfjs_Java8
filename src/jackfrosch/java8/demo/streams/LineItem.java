package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;
import java.util.Objects;

class LineItem {
    static long TIME_TO_CALCULATE_TOTAL = 50;

    private final Order order;
    private final String product;
    private final int quantity;
    private final BigDecimal salePrice;
    private final boolean taxable;

    LineItem(Order order, String product, int quantity,
                    BigDecimal salePrice, boolean taxable) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.taxable = taxable;
    }

    BigDecimal calculateTotal() {
        sleepAwhile();
        return salePrice.multiply(new BigDecimal(quantity));
    }

    boolean isTaxable() { return taxable; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(order, lineItem.order) &&
                Objects.equals(product, lineItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    private void sleepAwhile() {
        try {
            Thread.sleep(TIME_TO_CALCULATE_TOTAL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
