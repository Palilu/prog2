package ejercicio03.seach;

import ejercicio03.Member;
import ejercicio03.filters.MemberFilter;

import java.util.Comparator;

public class Searchs {

    public static MemberSearch filtered(MemberFilter filter) {
        return new SearchFiltered(filter);
    }

    public static MemberSearch sorted(MemberSearch value, Comparator<Member> comparator) {
        return new SearchSorted(value, comparator);
    }

    public static MemberSearch not(MemberSearch search) {
        return new SearchNot(search);
    }

    public static MemberSearch and(MemberSearch a, MemberSearch b) {
        return new SearchAnd(a, b);
    }

    public static MemberSearch or(MemberSearch a, MemberSearch b) {
        return new SearchOr(a, b);
    }
}
