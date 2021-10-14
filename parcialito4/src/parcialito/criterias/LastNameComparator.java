package parcialito.criterias;

import parcialito.SalesPerson;

import java.util.Comparator;

public class LastNameComparator implements Comparator<SalesPerson> {

    @Override
    public int compare(SalesPerson o1, SalesPerson o2) {
        return o1.getLname().compareTo(o2.getLname());
    }
}
