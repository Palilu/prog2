package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;

public interface DocumentFilter {

    List<Document> filter(List<Document> documents);
}
