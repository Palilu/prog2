package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;

public class AuthoredByDocumentFilter extends StringDocumentFilter {

    public AuthoredByDocumentFilter(String keyword) {
        super(keyword);
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return documents.stream()
                .filter(document -> document.getAuthors().contains(this.getKeyword()))
                .collect(Collectors.toList());
    }
}
