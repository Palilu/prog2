package ejercicio01.filters;

import ejercicio01.News;

public class TitleEqualsFilter implements NewsFilter {

    private String title;

    public TitleEqualsFilter(String title) {
        this.title = title;
    }

    @Override
    public Boolean matches(News news) {
        return news.getTitle().equals(title);
    }
}
