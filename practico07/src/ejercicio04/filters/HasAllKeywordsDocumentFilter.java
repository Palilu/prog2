package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;

public class HasAllKeywordsDocumentFilter extends ListStringDocumentFilter {

    public HasAllKeywordsDocumentFilter(List<String> keywords) {
        super(keywords);
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return documents.stream()
                .filter(document -> document.getKeywords().containsAll(this.getKeywords()))
                .collect(Collectors.toList());
    }
}
