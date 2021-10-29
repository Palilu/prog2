package parcial.filters;

import parcial.Trip;

public class FilterNot implements TripFilter {

    private TripFilter a;

    public FilterNot(TripFilter a) {
        this.a = a;
    }

    @Override
    public boolean matches(Trip trip) {
        return a.matches(trip);
    }
}
