package ejercicio03.seach;

import ejercicio03.Member;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSorted extends UnarySearch implements MemberSearch {

    private Comparator<Member> sort;

    public SearchSorted(MemberSearch value, Comparator<Member> sort) {
        super(value);
        this.sort = sort;
    }

    @Override
    public List<Member> search(List<Member> members) {
        return getValue().search(members).stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }
}
