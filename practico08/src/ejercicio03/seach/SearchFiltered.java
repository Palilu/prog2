package ejercicio03.seach;

import ejercicio03.Member;
import ejercicio03.filters.MemberFilter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchFiltered implements MemberSearch {

    private MemberFilter filter;

    public SearchFiltered(MemberFilter filter) {
        this.filter = filter;
    }
    @Override
    public List<Member> search(List<Member> members) {
        return members.stream()
                .filter(filter::matches)
                .collect(Collectors.toList());
    }
}
