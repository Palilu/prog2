package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;

public class TitleContainsDocumentFilter extends StringDocumentFilter {

    public TitleContainsDocumentFilter(String title) {
        super(title);
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return documents.stream()
                .filter(document -> document.getTitle().contains(getKeyword()))
                .collect(Collectors.toList());
    }
}
