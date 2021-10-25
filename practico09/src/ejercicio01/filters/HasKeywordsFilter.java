package ejercicio01.filters;

import ejercicio01.News;

import java.util.List;

public class HasKeywordsFilter implements NewsFilter {

    private List<String> keywords;

    public HasKeywordsFilter(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public Boolean matches(News news) {
        return news.containsKeywords(keywords);
    }
}
