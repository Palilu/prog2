package parcial.comparators;

import parcial.Trip;

import java.util.Comparator;

public class ByTo implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        return o1.getTo().compareTo(o2.getTo());
    }
}
