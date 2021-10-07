package ejercicio04.filters;

public abstract class StringDocumentFilter implements DocumentFilter {

    private String keyword;

    public StringDocumentFilter(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
