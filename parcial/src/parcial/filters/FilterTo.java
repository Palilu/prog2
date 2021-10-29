package parcial.filters;

import parcial.Trip;

public class FilterTo implements TripFilter {

    private String to;

    public FilterTo(String to) {
        this.to = to;
    }

    @Override
    public boolean matches(Trip trip) {
        return trip.getTo().equals(to);
    }
}
