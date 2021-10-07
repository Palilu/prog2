package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;

public class ContentContainsDocumentFilter extends StringDocumentFilter {

    public ContentContainsDocumentFilter(String keyword) {
        super(keyword);
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return documents.stream()
                .filter(document -> document.getContent().contains(this.getKeyword()))
                .collect(Collectors.toList());
    }
}
