package ejercicio01.filters;

import ejercicio01.News;

public interface NewsFilter {

    Boolean matches(News news);
}
