package ejercicio01;

import ejercicio01.filters.NewsFilter;

import java.util.List;

/**
 * Se desea modelar un administrador de contenidos de un sitio web de noticias. Los contenidos
 * del sitio están agrupados en categorías y dentro de cada categoría se dividen en secciones.
 * Asimismo, es posible que una sección se sub-divida nuevamente en otras sub secciones, y así
 * sucesivamente. Cada categoría, posee una descripción y una imagen asociada, lo mismo para
 * las secciones.
 */
public abstract class NewsNode {


    /**
     * El modelo presentado debe proveer servicios que permitan obtener la cantidad de noticias que
     * contiene una categoría, y la cantidad de noticias que contiene una sección, sub-sección, etc.
     */
    public abstract Integer getNewsCount();


    /**
     * Se debe proveer un mecanismo mediante el cual el administrador de contenidos pueda
     * restringirse a un tópico determinado, es decir ingresando una palabra clave se genera una
     * nueva interfaz en donde sólo las noticias que contienen esta palabra clave se muestran (es
     * importante que se respete la organización de las mismas, es decir categoría, sección,
     * sub-sección y así sucesivamente).
     * La nueva estructura obtenida es una copia de la existente, si se introduce un cambio en esta,
     * el mismo NO se refleja en la estructura original.
     */
    public abstract NewsNode copyWith(NewsFilter filer);


    public abstract List<News> getNews(NewsFilter filter);

    /**
     * Debido a la dinamicidad del sitio (se crean constantemente nuevas categorías, secciones,
     * sub-secciones) es necesario proveer un mecanismo que permita armar el mapa del sitio, es
     * decir, obtener un listado de los distintos niveles del sitio y los links asociados a cada una de
     * las noticias, por ejemplo a partir del contenido del sitio actual obtener una lista de la
     * siguiente forma:
     * Generales
     * Generales\Espectáculos
     * Generales\Espectáculos\Link 1
     * Generales\Espectáculos\Divorcios
     * Generales\Espectáculos\Divorcios\Link 2
     * Generales\Espectáculos\Divorcios\Link 3
     * Generales\Deportes
     * Generales\Deportes\Fútbol
     * Generales\Deportes\Fútbol\Link 4
     * Generales\Deportes\Link 5
     * Generales\Link 6
     * Solo se devuelven los nombres de las categorías/secciones y en el caso de las noticias el link
     * asociado. La lista resultado concatena la información de manera tal de contar con el path de
     * la estructura.
     * En el ejemplo anterior, el Link5 está dentro de la sección “Deportes”, la cual está dentro de
     * la categoría “Generales”.
     */
    public abstract String getPath(String prefix);
}
