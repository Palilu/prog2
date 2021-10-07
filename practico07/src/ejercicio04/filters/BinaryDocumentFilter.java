package ejercicio04.filters;

public abstract class BinaryDocumentFilter implements DocumentFilter {

    private DocumentFilter a;
    private DocumentFilter b;

    public BinaryDocumentFilter(DocumentFilter a, DocumentFilter b) {
        this.a = a;
        this.b = b;
    }

    public DocumentFilter getA() {
        return a;
    }

    public DocumentFilter getB() {
        return b;
    }
}
