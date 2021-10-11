package ejercicio03.filters;

import ejercicio03.FieldRent;
import ejercicio03.Member;

import java.util.stream.Collectors;

public class FieldRentedNumberFilter implements MemberFilter {

    private Integer fieldNumber;

    public FieldRentedNumberFilter(Integer fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    @Override
    public boolean matches(Member member) {
        return member.getFieldRents().stream()
                .map(FieldRent::getFiledNumber)
                .collect(Collectors.toList()).contains(fieldNumber);
    }
}
