package ejercicio06;

import java.util.ArrayList;
import java.util.List;

public class Paper {

    private String name;
    private PaperType type;
    protected List<String> keywords = new ArrayList<>();

    public Paper(String name, PaperType type, List<String> keywords) {
        this.name = name;
        this.type = type;
        this.keywords = keywords;
    }

    public Boolean isSuitable(Reviewer reviewer) {
        return reviewer.getFieldsOfExpertise().containsAll(keywords);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
