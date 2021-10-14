package parcialito.filters;

import parcialito.SalesPerson;

public class OrFilter implements Filter {

    private Filter a;
    private Filter b;

    public OrFilter(Filter a, Filter b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean matches(SalesPerson salesPerson) {
        return a.matches(salesPerson) || b.matches(salesPerson);
    }
}
