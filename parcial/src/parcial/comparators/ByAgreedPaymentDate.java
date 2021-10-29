package parcial.comparators;

import parcial.Trip;

import java.util.Comparator;
import java.util.Optional;

public class ByAgreedPaymentDate implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        var d1 = Optional.of(o1.getAgreedPaymentDate());
        var d2 = Optional.of(o2.getAgreedPaymentDate());
        // (los que no tienen fecha acordada deben ir a lo último)
        if (d1.isEmpty() && d2.isEmpty()) {
            return 0;
        }
        if (d1.isEmpty()) {
            return -1;
        }
        if (d2.isEmpty()) {
            return 1;
        }
        return d1.get().compareTo(d2.get());
    }
}
