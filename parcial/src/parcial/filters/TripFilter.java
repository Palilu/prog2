package parcial.filters;

import parcial.Trip;

public interface TripFilter {

    boolean matches(Trip trip);
}
