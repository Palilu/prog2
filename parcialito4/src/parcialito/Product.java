package parcialito;

import java.time.LocalDate;

/**
 * De cada producto
 *  * vendido por un vendedor se registra la fecha de venta,
 *  * el código del producto, el dni del comprador, el monto al
 *  * que se vendió y la cantidad vendida de ese producto.
 */
public class Product {

    private LocalDate saleDate;
    private String code;
    private String buyerId;
    private Double price;
    private Integer quantity;

    public Product(LocalDate saleDate, String code, String buyerId, Double price, Integer quantity) {
        this.saleDate = saleDate;
        this.code = code;
        this.buyerId = buyerId;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Las ganancias por una venta se calculan como el monto
     *  * al que se vendió el producto, por la cantidad de
     *  * productos vendidos.
     */
    public Double getEarnings() {
        return price * quantity;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public String getCode() {
        return code;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "parcialito.Product{" +
                "saleDate=" + saleDate +
                ", code='" + code + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
