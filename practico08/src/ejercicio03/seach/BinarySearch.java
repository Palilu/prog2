package ejercicio03.seach;

public abstract class BinarySearch extends UnarySearch implements MemberSearch {

    private MemberSearch b;

    public BinarySearch(MemberSearch a, MemberSearch b) {
        super(a);
        this.b = b;
    }

    public MemberSearch getA() {
        return getValue();
    }

    public MemberSearch getB() {
        return b;
    }
}
