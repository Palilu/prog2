package parcial.comparators;

import parcial.Trip;

import java.util.Comparator;

public class ByThisThen implements Comparator<Trip> {

    private Comparator<Trip> that;
    private Comparator<Trip> then;

    public ByThisThen(Comparator<Trip> that, Comparator<Trip> then) {
        this.that = that;
        this.then = then;
    }

    @Override
    public int compare(Trip o1, Trip o2) {
        int thatResult = that.compare(o1, o2);
        return thatResult == 0 ? then.compare(o1, o2) : thatResult;
    }
}
