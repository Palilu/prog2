package parcialito.filters;

import parcialito.SalesPerson;

public class NotFilter implements Filter {

    private Filter a;

    public NotFilter(Filter a) {
        this.a = a;
    }

    @Override
    public boolean matches(SalesPerson salesPerson) {
        return !a.matches(salesPerson);
    }
}
