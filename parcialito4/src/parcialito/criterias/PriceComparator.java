package parcialito.criterias;

import parcialito.SalesPerson;

import java.util.Comparator;

public class PriceComparator implements Comparator<SalesPerson> {

    @Override
    public int compare(SalesPerson o1, SalesPerson o2) {
        return o1.getTotalCatalogPrice().compareTo(o2.getTotalCatalogPrice());
    }
}
