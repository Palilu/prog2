package ejercicio03.filters;

import ejercicio03.Member;

public class InDebtFilter implements MemberFilter {

    @Override
    public boolean matches(Member member) {
        return !member.getUpToDate();
    }
}
