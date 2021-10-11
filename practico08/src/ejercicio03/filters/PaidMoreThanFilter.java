package ejercicio03.filters;

import ejercicio03.FieldRent;
import ejercicio03.Member;

public class PaidMoreThanFilter implements MemberFilter {

    private double amountPaid;

    public PaidMoreThanFilter(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public boolean matches(Member member) {
        return member.getFieldRents().stream()
                .map(FieldRent::getCost)
                .filter(cost -> cost.compareTo(amountPaid) >= 0)
                .findFirst()
                .isPresent();
    }
}
