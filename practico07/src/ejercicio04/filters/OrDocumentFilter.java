package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrDocumentFilter extends BinaryDocumentFilter {

    public OrDocumentFilter(DocumentFilter a, DocumentFilter b) {
        super(a, b);
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return Stream.concat(getA().filter(documents).stream(), getB().filter(documents).stream())
                .collect(Collectors.toList());
    }
}
