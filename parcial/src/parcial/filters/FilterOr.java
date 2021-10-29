package parcial.filters;

import parcial.Trip;

public class FilterOr implements TripFilter {

    private TripFilter a;
    private TripFilter b;

    public FilterOr(TripFilter a, TripFilter b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean matches(Trip trip) {
        return a.matches(trip) || b.matches(trip);
    }
}
