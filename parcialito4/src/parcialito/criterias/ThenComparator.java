package parcialito.criterias;

import parcialito.SalesPerson;

import java.util.Comparator;

public class ThenComparator implements Comparator<SalesPerson> {

    private Comparator<SalesPerson> first;
    private Comparator<SalesPerson> then;

    public ThenComparator(Comparator<SalesPerson> first, Comparator<SalesPerson> then) {
        this.first = first;
        this.then = then;
    }

    @Override
    public int compare(SalesPerson o1, SalesPerson o2) {
        return first.thenComparing(then).compare(o1, o2);
    }
}
