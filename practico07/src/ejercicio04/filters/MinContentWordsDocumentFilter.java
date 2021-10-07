package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;

public class MinContentWordsDocumentFilter implements DocumentFilter {

    private int minWords;

    public MinContentWordsDocumentFilter(int minWords) {
        this.minWords = minWords;
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return documents.stream()
                .filter(document -> document.getContent().split(" ").length >= minWords)
                .collect(Collectors.toList());
    }
}
