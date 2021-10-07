package ejercicio04.filters;

import java.util.List;

public class DocumentFilters {

    public static DocumentFilter titleEquals(String title) {
        return new TitleEqualsDocumentFilter(title);
    }

    public static DocumentFilter titleContains(String title) {
        return new TitleContainsDocumentFilter(title);
    }

    public static DocumentFilter hasKeyword(String keyword) {
        return new HasKeywordDocumentFilter(keyword);
    }

    public static DocumentFilter hasAllKeywords(List<String> keywords) {
        return new HasAllKeywordsDocumentFilter(keywords);
    }

    public static DocumentFilter not(DocumentFilter documentFilter) {
        return new NotDocumentFilter(documentFilter);
    }

    public static DocumentFilter authoredBy(String author) {
        return new AuthoredByDocumentFilter(author);
    }

    public static DocumentFilter contentContains(String phrase) {
        return new ContentContainsDocumentFilter(phrase);
    }

    public static DocumentFilter minContentWords(int minWords) {
        return new MinContentWordsDocumentFilter(minWords);
    }

    public static DocumentFilter and(DocumentFilter a, DocumentFilter b) {
        return new AndDocumentFilter(a, b);
    }

    public static DocumentFilter or(DocumentFilter a, DocumentFilter b) {
        return new OrDocumentFilter(a, b);
    }
}
