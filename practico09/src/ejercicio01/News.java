package ejercicio01;

import ejercicio01.filters.NewsFilter;

import java.util.Collections;
import java.util.List;

/**
 * Una noticia puede estar asociada a una categoría, sección o sub-sección, posee un título, un
 * listado de palabras claves, una introducción, el texto, el autor, y un link asociado.
 */
public class News extends NewsNode {
    private String title;
    private List<String> keywords;
    private String introduction;
    private String text;
    private String author;
    private String link;

    public News(String title, List<String> keywords, String introduction, String text, String author, String link) {
        this.title = title;
        this.keywords = keywords;
        this.introduction = introduction;
        this.text = text;
        this.author = author;
        this.link = link;
    }

    public Boolean containsKeywords(List<String> keywords) {
        return this.keywords.containsAll(keywords);
    }

    @Override
    public Integer getNewsCount() {
        return 1;
    }

    @Override
    public NewsNode copyWith(NewsFilter filter) {
        return filter.matches(this) ? new News(title, keywords, introduction, text, author, link) : null;
    }

    @Override
    public List<News> getNews(NewsFilter filter) {
        return filter.matches(this) ? List.of(this) : Collections.EMPTY_LIST;
    }

    @Override
    public String getPath(String prefix) {
        return prefix + "/" + link + System.lineSeparator();
    }

    public String getTitle() {
        return title;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", keywords=" + keywords +
                ", introduction='" + introduction + '\'' +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
