package parcialito.filters;

import parcialito.SalesPerson;

public interface Filter {

    boolean matches(SalesPerson salesPerson);
}
