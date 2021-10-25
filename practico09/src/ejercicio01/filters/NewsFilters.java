package ejercicio01.filters;

import java.util.List;

/**
 * Adicionalmente se debe proveer servicios que permitan la búsqueda de noticias, por ejemplo:
 */
public class NewsFilters {

    /**
     * 1. Buscar todas las noticias donde el largo del texto sea superior a 200.
    */
    public static NewsFilter minTextLenght(Integer minTextLenght) {
        return null;
    }

    /**
     * 2. Buscar todas las noticias del autor “Juan Pérez”.
     */
    public static NewsFilter authoredBy(String author) {
        return null;
    }

    /**
     * 3. Buscar todas las noticias que posean la palabra clave “Partido” y la palabra Clave “Goleada”
     */
    public static NewsFilter containsKeywords(List<String> keywords) {
        return new HasKeywordsFilter(keywords);
    }

    /**
     * 4. Buscar las noticias que el título sea “Ultimo momento”.
     */
    public static NewsFilter titleEquals(String title) {
        return new TitleEqualsFilter(title);
    }

    /**
     * Los anteriores son sólo algunos ejemplos de búsqueda. Los distintos tipos de búsqueda
     *  * también pueden combinarse.
     */
    public static NewsFilter and(NewsFilter f1, NewsFilter f2) {
        return null;
    }

    /**
     * Los anteriores son sólo algunos ejemplos de búsqueda. Los distintos tipos de búsqueda
     *  * también pueden combinarse.
     */
    public static NewsFilter or(NewsFilter f1, NewsFilter f2) {
        return null;
    }

    /**
     * Los anteriores son sólo algunos ejemplos de búsqueda. Los distintos tipos de búsqueda
     *  * también pueden combinarse.
     */
    public static NewsFilter not(NewsFilter f1) {
        return null;
    }
}
