package parcialito;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.summingInt;

/**
 * De cada vendedor se registra su nombre, apellido, edad
 *  * y la lista de productos vendidos.
 */
public class SalesPerson {

    private String fname;
    private String lname;
    private Integer age;
    private List<Product> catalog;

    public SalesPerson(String fname, String lname, Integer age, List<Product> catalog) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.catalog = catalog;
    }

    public Double getTotalCatalogEarnings() {
        return this.catalog.stream()
                .collect(summingDouble(Product::getEarnings));
    }

    public Double getTotalCatalogPrice() {
        return this.catalog.stream()
                .collect(summingDouble(Product::getPrice));
    }

    public Integer getTotalCatalogQuantity() {
        return this.catalog.stream()
                .collect(summingInt(Product::getQuantity));
    }

    public Double getPriceByAge() {
        return this.getTotalCatalogPrice() / this.getAge();
    }

    public Double getSalesRatio() {
        return this.getTotalCatalogPrice() / this.getTotalCatalogQuantity();
    }

    public Boolean soldProductCode(String productCode) {
        return catalog.stream()
                .map(Product::getCode)
                .filter(productCode::equals)
                .findFirst()
                .isPresent();
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Integer getAge() {
        return age;
    }

    public List<Product> getCatalog() {
        return new ArrayList<>(catalog);
    }

    @Override
    public String toString() {
        return this.fname + " {" +
                "defecto='" + this.getTotalCatalogEarnings() + '\'' +
                "precioTotal='" + this.getTotalCatalogPrice() + '\'' +
                "cantidadTotal='" + this.getTotalCatalogQuantity() + '\'' +
                "precio total sobre edad='" + this.getPriceByAge() + '\'' +
                "radio de ventas='" + this.getSalesRatio() + '\'' + '}';
    }
}
