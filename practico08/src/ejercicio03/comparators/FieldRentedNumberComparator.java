package ejercicio03.comparators;

import ejercicio03.FieldRent;
import ejercicio03.Member;

import java.util.Comparator;
import java.util.List;

public class FieldRentedNumberComparator implements Comparator<Member> {

    private Integer fieldNumber;

    public FieldRentedNumberComparator(Integer fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    @Override
    public int compare(Member o1, Member o2) {
        return getFieldRentCount(o1.getFieldRents()).compareTo(getFieldRentCount(o2.getFieldRents()));
    }

    public Long getFieldRentCount(List<FieldRent> fieldRents) {
        return fieldRents.stream()
                .map(FieldRent::getFiledNumber)
                .filter(this.fieldNumber::equals)
                .count();
    }
}
