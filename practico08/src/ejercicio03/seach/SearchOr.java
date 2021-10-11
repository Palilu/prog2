package ejercicio03.seach;

import ejercicio03.Member;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchOr extends BinarySearch {

    public SearchOr(MemberSearch a, MemberSearch b) {
        super(a, b);
    }

    @Override
    public List<Member> search(List<Member> members) {
        return Stream.concat(getA().search(members).stream(), getB().search(members).stream())
                .collect(Collectors.toList());
    }
}
