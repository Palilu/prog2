package parcialito.filters;

import parcialito.SalesPerson;

public class ProductCodeEqualsFilter implements Filter {

    private String productCode;

    public ProductCodeEqualsFilter(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean matches(SalesPerson salesPerson) {
        return salesPerson.soldProductCode(productCode);
    }
}
