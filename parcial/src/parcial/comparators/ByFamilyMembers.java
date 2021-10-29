package parcial.comparators;

import parcial.Trip;

import java.util.Comparator;

public class ByFamilyMembers implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        return o1.getFamilyMembers().compareTo(o2.getFamilyMembers());
    }
}
