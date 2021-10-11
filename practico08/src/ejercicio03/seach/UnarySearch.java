package ejercicio03.seach;

public abstract class UnarySearch implements MemberSearch {

    private MemberSearch value;

    public UnarySearch(MemberSearch value) {
        this.value = value;
    }

    public MemberSearch getValue() {
        return value;
    }
}
