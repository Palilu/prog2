package parcial.comparators;

import parcial.Trip;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Trip> byId() {
        return new ById();
    }

    public static Comparator<Trip> byCost() {
        return new ByCost();
    }

    public static Comparator<Trip> byFrom() {
        return new ByFrom();
    }

    public static Comparator<Trip> byTo() {
        return new ByTo();
    }

    public static Comparator<Trip> byAgreedPaymentDate() {
        return new ByAgreedPaymentDate();
    }

    public static Comparator<Trip> byThisThen(Comparator<Trip> that, Comparator<Trip> then) {
        return new ByThisThen(that, then);
    }

    public static Comparator<Trip> byFamilyMembers() {
        return new ByFamilyMembers();
    }
}
