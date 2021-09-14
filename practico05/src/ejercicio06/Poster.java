package ejercicio06;

import java.util.List;

import static java.util.function.Predicate.not;

public class Poster extends Paper {

    public Poster(String name, List<String> keywords) {
        super(name, PaperType.POSTER, keywords);
    }

    @Override
    public Boolean isSuitable(Reviewer reviewer) {
        return keywords.stream()
                .filter(not(reviewer.getFieldsOfExpertise()::contains))
                .findAny()
                .isEmpty();
    }
}
