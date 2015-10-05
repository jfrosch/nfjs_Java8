package jackfrosch.java8.demo.streams;

import java.math.BigDecimal;
import java.util.Objects;

class LineItem {
    private Order order;
    private String product;
    private int quantity;
    private BigDecimal salePrice;
    private boolean taxable;

    LineItem(Order order, String product, int quantity,
                    BigDecimal salePrice, boolean taxable) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.taxable = taxable;
    }

    BigDecimal calculateTotal() {
        return salePrice.multiply(new BigDecimal(quantity));
    }

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

    Order getOrder() { return order; }
    String getProduct() { return product; }
    int getQuantity() { return quantity; }
    BigDecimal getSalePrice() { return salePrice; }
    boolean isTaxable() { return taxable;}

    void setOrder(Order order) { this.order = order; }
    void setProduct(String product) { this.product = product; }
    void setQuantity(int quantity) { this.quantity = quantity; }
    void setSalePrice(BigDecimal salePrice) { this.salePrice = salePrice; }
    void setTaxable(boolean taxable) { this.taxable = taxable; }


}
