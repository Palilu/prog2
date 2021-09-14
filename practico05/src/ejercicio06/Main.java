package ejercicio06;

import java.util.List;

/**
 * 6 - Congreso de Ciencias de la Computación
 *
 * El comité organizador de un Congreso de Ciencias de la Computación necesita un sistema
 * que le ayude a asignar evaluadores de los trabajos enviados al congreso. Para esto cuenta con
 * un conjunto de evaluadores, calificados como “generales” cuando conocen temas generales
 * como algoritmos, lenguajes de programación, etc., o como evaluadores “expertos” cuando
 * conocen temas específicos como agentes, visualización, redes de comunicación, etc. El
 * sistema debe designar a un evaluador para cada uno de los distintos trabajos enviados al
 * congreso, existiendo diferentes categorías de trabajos: artículo, resumen y poster. Cada
 * trabajo posee un conjunto de palabras claves que definen los temas tratados en el trabajo.
 * Para asignar un evaluador a un trabajo, el sistema debe asegurarse que el evaluador es apto
 * para evaluar el trabajo. Para determinar si un evaluador es apto para evaluar un trabajo, éste
 * debe haber declarado conocimiento en todos los temas del trabajo, especificados en sus
 * palabras claves. Para el caso de los posters, basta que el evaluador tenga conocimiento en uno
 * de los temas del poster o sea en una de las palabras clave.
 * Implementar una solución orientada a objetos para este problema que permita determinar
 * 1) qué evaluador puede asignarse a un determinado trabajo,
 * 2) qué trabajos pueden asignarse un evaluador particular, y
 * 3) cuántos trabajos tiene un evaluador determinado y
 * 4) determinar si un evaluador dado es general o experto.
 */
public class Main {
    private static final String TEMA_1 = "algoritmos";
    private static final String TEMA_2 = "lenguajes de programación";
    private static final String TEMA_3 = "agentes";
    private static final String TEMA_4 = "visualización";
    private static final String TEMA_5 = "redes de comunicación";

    public static void main(String[] args) {
        Reviewer luis = new Reviewer("Luis", ReviewerType.GENERAL, List.of(TEMA_1, TEMA_2, TEMA_4));
        // El poder del lado oscuro hace experto a Marcelo
        Reviewer marcelo = new Reviewer("Marcelo", ReviewerType.EXPERT, List.of(TEMA_3, TEMA_4, TEMA_5));
        ReviewerPool reviewerPool = new ReviewerPool(List.of(luis, marcelo));
        Paper p1 = new Paper("POO para mamertos", PaperType.ARTICULO, List.of(TEMA_1, TEMA_2));
        Paper p2 = new Paper("POO para cracks", PaperType.RESUMEN, List.of(TEMA_3, TEMA_4, TEMA_5));
        Paper p3 = new Poster("Dibujo hecho en paint de objetos y referencias", List.of(TEMA_4));

        // 1) qué evaluador puede asignarse a un determinado trabajo,
        System.out.println("El reviewer de p1 es " + reviewerPool.getReviewer(p1).getName());
        System.out.println("El reviewer de p2 es " + reviewerPool.getReviewer(p2).getName());
        System.out.println("El reviewer de p3 es " + reviewerPool.getReviewer(p3).getName());
        // 2) qué trabajos pueden asignarse un evaluador particular
        System.out.println("Luis puede revisar " + luis.getAssignablePapers(List.of(p1, p2, p3)));
        System.out.println("Marcelo puede revisar " + marcelo.getAssignablePapers(List.of(p1, p2, p3)));
        // 3) cuántos trabajos tiene un evaluador determinado
        System.out.println("Luis tiene " + luis.getPapersAmount() + " trabajos.");
        System.out.println("Marcelo tiene " + marcelo.getPapersAmount() + " trabajos.");
        // 4) determinar si un evaluador dado es general o experto.
        System.out.println("Luis es " + (luis.isExpert() ? "Experto" : "Crack"));
        System.out.println("Marcelo es " + (marcelo.isExpert() ? "Experto" : "Crack"));
    }
}
