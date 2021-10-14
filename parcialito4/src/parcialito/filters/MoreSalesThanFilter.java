package parcialito.filters;

import parcialito.SalesPerson;

public class MoreSalesThanFilter implements Filter {

    private Double totalSales;
    public MoreSalesThanFilter(Double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public boolean matches(SalesPerson salesPerson) {
        return salesPerson.getTotalCatalogPrice().compareTo(totalSales) > 0;
    }
}
