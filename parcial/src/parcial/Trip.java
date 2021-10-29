package parcial;

import parcial.filters.TripFilter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public abstract class Trip {
    private Integer id;
    private Integer familyMembers;

    public Trip(Integer id, Integer familyMembers) {
        this.id = id;
        this.familyMembers = familyMembers;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFamilyMembers() {
        return familyMembers;
    }

    public abstract String getFrom();

    public abstract String getTo();

    public abstract Double getCost();

    public abstract LocalDate getAgreedPaymentDate();

    public List<Trip> getMatches(TripFilter filter) {
        return filter.matches(this) ? List.of(this) : Collections.EMPTY_LIST;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", familyMembers=" + familyMembers +
                ", from=" + getFrom() +
                ", to=" + getTo() +
                ", cost=" + getCost() +
                ", agreedPaymentDate=" + getAgreedPaymentDate() +
                '}';
    }
}
