package parcial.filters;

import parcial.Trip;

public class FilterCostMoreThan implements TripFilter {

    private Double amount;

    public FilterCostMoreThan(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean matches(Trip trip) {
        return trip.getCost() > amount;
    }
}
