package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;

public class NotDocumentFilter implements DocumentFilter {

    private DocumentFilter documentFilter;

    public NotDocumentFilter(DocumentFilter documentFilter) {
        this.documentFilter = documentFilter;
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        List<Document> filtered = documentFilter.filter(documents);
        return documents.stream()
                .filter(document -> !filtered.contains(document))
                .collect(Collectors.toList());

    }
}
