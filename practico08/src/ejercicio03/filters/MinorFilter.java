package ejercicio03.filters;

import ejercicio03.Member;

public class MinorFilter implements MemberFilter {

    private static final Integer ADULT_AGE = 18;

    @Override
    public boolean matches(Member member) {
        return ADULT_AGE >= member.getAge();
    }
}
