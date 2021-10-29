package parcial.filters;

import parcial.Trip;

import java.time.LocalDate;

public class FilterArreedPaymentDate implements TripFilter {

    private LocalDate paymentDate;

    public FilterArreedPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean matches(Trip trip) {
        return paymentDate.equals(trip.getAgreedPaymentDate());
    }
}
