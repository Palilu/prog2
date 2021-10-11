package ejercicio03.filters;

public class Filters {

    public static MemberFilter inDebt() {
        return new InDebtFilter();
    }

    public static MemberFilter minor() {
        return new MinorFilter();
    }

    public static MemberFilter rentedFieldNumber(Integer fieldNumber) {
        return new FieldRentedNumberFilter(fieldNumber);
    }

    public static MemberFilter paidMoreThan(Double amountPaid) {
        return new PaidMoreThanFilter(amountPaid);
    }
}
