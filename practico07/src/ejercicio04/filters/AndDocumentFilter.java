package ejercicio04.filters;

import ejercicio04.Document;

import java.util.List;

public class AndDocumentFilter extends BinaryDocumentFilter {

    public AndDocumentFilter(DocumentFilter a, DocumentFilter b) {
        super(a, b);
    }

    @Override
    public List<Document> filter(List<Document> documents) {
        return getA().filter(getB().filter(documents));
    }
}
