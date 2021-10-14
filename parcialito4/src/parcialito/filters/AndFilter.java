package parcialito.filters;

import parcialito.SalesPerson;

public class AndFilter implements Filter {

    private Filter a;
    private Filter b;

    public AndFilter(Filter a, Filter b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean matches(SalesPerson salesPerson) {
        return a.matches(salesPerson) && b.matches(salesPerson);
    }
}
