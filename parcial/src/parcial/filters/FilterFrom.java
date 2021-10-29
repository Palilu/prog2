package parcial.filters;

import parcial.Trip;

public class FilterFrom implements TripFilter {

    private String from;

    public FilterFrom(String from) {
        this.from = from;
    }

    @Override
    public boolean matches(Trip trip) {
        return trip.getFrom().equals(from);
    }
}
