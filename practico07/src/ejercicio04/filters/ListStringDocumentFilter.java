package ejercicio04.filters;

import java.util.ArrayList;
import java.util.List;

public abstract class ListStringDocumentFilter implements DocumentFilter {

    private List<String> keywords;

    public ListStringDocumentFilter(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return new ArrayList<>(keywords);
    }
}
