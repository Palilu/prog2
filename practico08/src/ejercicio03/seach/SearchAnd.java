package ejercicio03.seach;

import ejercicio03.Member;

import java.util.List;

public class SearchAnd extends BinarySearch {

    public SearchAnd(MemberSearch a, MemberSearch b) {
        super(a, b);
    }

    @Override
    public List<Member> search(List<Member> members) {
        return getA().search(getB().search(members));
    }
}
