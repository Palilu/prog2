package parcial.filters;

import parcial.Trip;

public class FilterAnd implements TripFilter {

    private TripFilter a;
    private TripFilter b;

    public FilterAnd(TripFilter a, TripFilter b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean matches(Trip trip) {
        return a.matches(trip) && b.matches(trip);
    }
}
