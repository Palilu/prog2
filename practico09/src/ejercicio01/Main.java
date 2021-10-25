package ejercicio01;

import ejercicio01.filters.NewsFilters;
import java.util.List;

/**
 * 1. Sitio Web de Noticias
 *
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
public class Main {

    public static void main(String[] args) {
//        Se desea modelar un administrador de contenidos de un sitio web de noticias. Los contenidos
//        del sitio están agrupados en categorías y dentro de cada categoría se dividen en secciones.
//                Asimismo, es posible que una sección se sub-divida nuevamente en otras sub secciones, y así
//        sucesivamente. Cada categoría, posee una descripción y una imagen asociada, lo mismo para
//        las secciones.
//        Una noticia puede estar asociada a una categoría, sección o sub-sección, posee un título, un
//        listado de palabras claves, una introducción, el texto, el autor, y un link asociado.
        News n1 = new News("Daddy brieva es demasiado kuka", List.of("K"), "El artista tuvo público negativo", "Un curioso incidente en carlos paz...", "Lanata", "Link 1");
        News n2 = new News("Wanda Nara se fue al pasto", List.of("Cuernos"), "La botinera calificó a la china suarez de", "@%$@%$ es la forma en la que...", "Polino", "Link 2");
        News n3 = new News("Icardi se hizo el boludo", List.of("Cuernos"), "El futbolista del PSG no olvida el arte argento", "A veces para zafar hay que hacerce el...", "Varsky", "Link 3");
        News n4 = new News("Perdió Boquita", List.of("Perdedor", "Partido", "Goleada"), "Otra noche para el olvido", "Les rompieron el...", "Bonadeo", "Link 4");
        News n5 = new News("Perdió Campazzo", List.of("Perdedor"), "Otra noche para el olvido", "Le rompieron el...", "Bonadeo", "Link 5");
        News n6 = new News("Perdió Espert", List.of("Perdedor"), "Otra noche para el olvido", "Le rompieron el...", "Lanata", "Link 6");
        NewsGroup divorcios = new NewsGroup("Divorcios", "divorcios.png");
        divorcios.addElements(List.of(n2, n3));
        NewsGroup espectaculos = new NewsGroup("Espectaculos", "espectaculos.png");
        espectaculos.addElements(List.of(n1, divorcios));
        NewsGroup fulbo = new NewsGroup("Futbol", "futbol.png");
        fulbo.addElements(List.of(n4));
        NewsGroup deportes = new NewsGroup("Deportes", "deportes.png");
        deportes.addElements(List.of(fulbo, n5));
        NewsGroup generales = new NewsGroup("Generales", "generales.png");
        generales.addElements(List.of(espectaculos, deportes, n6));
//        El modelo presentado debe proveer servicios que permitan obtener la cantidad de noticias que
//        contiene una categoría, y la cantidad de noticias que contiene una sección, sub-sección, etc.
        System.out.println("Generales tiene " + generales.getNewsCount() + " noticias.");
        System.out.println("Espectaculos tiene " + espectaculos.getNewsCount() + " noticias.");
        System.out.println("Deportes tiene " + deportes.getNewsCount() + " noticias.");
//        Se debe proveer un mecanismo mediante el cual el administrador de contenidos pueda
//        restringirse a un tópico determinado, es decir ingresando una palabra clave se genera una
//        nueva interfaz en donde sólo las noticias que contienen esta palabra clave se muestran (es
//        importante que se respete la organización de las mismas, es decir categoría, sección,
//        sub-sección y así sucesivamente).
        NewsNode copiaPerdedores = generales.copyWith(NewsFilters.containsKeywords(List.of("Perdedor")));
        NewsNode copiaCuernos = generales.copyWith(NewsFilters.containsKeywords(List.of("Cuernos")));
//        Adicionalmente se debe proveer servicios que permitan la búsqueda de noticias, por
//        ejemplo:
//        1. Buscar todas las noticias donde el largo del texto sea superior a 200.
//        2. Buscar todas las noticias del autor “Juan Pérez”.
//        3. Buscar todas las noticias que posean la palabra clave “Partido” y la palabra Clave
//“Goleada”.
//        4. Buscar las noticias que el título sea “Ultimo momento”.
        //System.out.println("Buscar todas las noticias donde el largo del texto sea superior a 200");
        //generales.getNews(NewsFilters.minTextLenght(200)).forEach(System.out::println);
        //System.out.println("Buscar todas las noticias del autor 'Juan Pérez'.");
        //generales.getNews(NewsFilters.authoredBy("Juan Perez")).forEach(System.out::println);
        System.out.println("Buscar todas las noticias que posean la palabra clave 'Partido' y la palabra Clave 'Goleada'");
        generales.getNews(NewsFilters.containsKeywords(List.of("Partido", "Goleada"))).forEach(System.out::println);
        System.out.println("Titulos con Ultimo momento:");
        generales.getNews(NewsFilters.titleEquals("Ultimo momento")).forEach(System.out::println);
//        Debido a la dinamicidad del sitio (se crean constantemente nuevas categorías, secciones,
//        sub-secciones) es necesario proveer un mecanismo que permita armar el mapa del sitio, es
//        decir, obtener un listado de los distintos niveles del sitio y los links asociados a cada una de
//        las noticias, por ejemplo a partir del contenido del sitio actual obtener una lista de la
//        siguiente forma:
//        Generales
//        Generales\Espectáculos
//        Generales\Espectáculos\Link 1
//        Generales\Espectáculos\Divorcios
//        Generales\Espectáculos\Divorcios\Link 2
//        Generales\Espectáculos\Divorcios\Link 3
//        Generales\Deportes
//        Generales\Deportes\Fútbol
//        Generales\Deportes\Fútbol\Link 4
//        Generales\Deportes\Link 5
//        Generales\Link 6
//        Solo se devuelven los nombres de las categorías/secciones y en el caso de las noticias el link
//        asociado. La lista resultado concatena la información de manera tal de contar con el path de
//        la estructura.
//        En el ejemplo anterior, el Link5 está dentro de la sección “Deportes”, la cual está dentro de
//        la categoría “Generales”.
        System.out.println("Original:");
        System.out.println(generales.getPath(""));
        System.out.println("Copia de perdedores:");
        System.out.println(copiaPerdedores.getPath(""));
        System.out.println("Copia de cuernos:");
        System.out.println(copiaCuernos.getPath(""));
    }
}
