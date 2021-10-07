package ejercicio04;

import java.util.List;

public class Document {
    private String title;
    private List<String> authors;
    private String content;
    private List<String> keywords;

    public Document(String title, List<String> authors, String content, List<String> keywords) {
        this.title = title;
        this.authors = authors;
        this.content = content;
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getContent() {
        return content;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", keywords=" + keywords +
                '}';
    }
}
