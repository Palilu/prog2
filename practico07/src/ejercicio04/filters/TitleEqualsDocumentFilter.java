package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;

public class TitleEqualsDocumentFilter extends StringDocumentFilter {

    public TitleEqualsDocumentFilter(String title) {
        super(title);
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return documents.stream()
                .filter(document -> this.getKeyword().equals(document.getTitle()))
                .collect(Collectors.toList());
    }
}
