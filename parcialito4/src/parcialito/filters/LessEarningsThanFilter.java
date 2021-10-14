package parcialito.filters;

import parcialito.SalesPerson;

public class LessEarningsThanFilter implements Filter {

    private Double totalEarnings;

    public LessEarningsThanFilter(Double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    @Override
    public boolean matches(SalesPerson salesPerson) {
        return salesPerson.getTotalCatalogEarnings().compareTo(totalEarnings) <= 0;
    }
}
