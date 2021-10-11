package ejercicio03.seach;

import ejercicio03.Member;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchNot extends UnarySearch implements MemberSearch {

    public SearchNot(MemberSearch value) {
        super(value);
    }

    @Override
    public List<Member> search(List<Member> members) {
        List yes = getValue().search(members);
        return members.stream()
                .filter(Predicate.not(yes::contains))
                .collect(Collectors.toList());
    }
}
