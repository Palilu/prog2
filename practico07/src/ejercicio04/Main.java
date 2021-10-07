package ejercicio04;

import ejercicio04.filters.DocumentFilters;

import java.util.List;

import static ejercicio04.filters.DocumentFilters.*;

/**
 * 4. Búsqueda de documentos
 * Un historiador desea digitalizar sus documentos y organizarlo de acuerdo a palabras clave.
 * Un documento tiene un título, una lista de autores, un contenido textual y una lista de
 * palabras clave. El historiador necesita poder encontrar fácilmente documentos en su
 * colección de acuerdo a diferentes criterios, por ejemplo:
 * a) Todos los documentos cuyo título sea exactamente igual a un título dado.
 * b) Todos los documentos cuyo título contenga una palabra o frase dada.
 * c) Todos los documentos que contengan una palabra clave dada.
 * d) Todos los documentos que no contengan ninguna palabra clave.
 * e) Todos los documentos de un autor determinado.
 * f) Todos los documentos cuyo contenido tenga una palabra o frase dada.
 * g) Todos los documentos cuyo contenido tenga al menos 20 palabras.
 * h) Cualquier combinación lógica de las formas anteriores.
 */
public class Main {

    private static final String MATRIX_CONTENT = "Cypher: Yeah. Trinity: Is everything in place? Cypher: You weren’t supposed to relieve me. Trinity: I know, but I felt like taking your shift. Cypher: You like him, don’t you? You like watching him. Trinity: Don’t be ridiculous. Cypher: We’re going to kill him, do you understand that? Trinity: Morpheus believes he is The One";
    private static final String POTTER_CONTENT = "1 EXT. NUMBER FOUR PRIVET DRIVE - MIDDLE OF THE NIGHT 1 The street slumbers, adrift in shadow. Then... a curious BEAM OF LIGHT BOBS beyond the second-story window of Number Four. 2 INT. HARRY'S ROOM - SAME TIME - MIDDLE OF THE NIGHT 2 A tent of blankets. Within... the SHADOW of a BOY. A WHISPER: HARRY Lumos Maxima...";


    public static void main(String[] args) {
        Document d1 = new Document("The Matrix", List.of("Lana Wachoswski", "Lilly Wachowski"),  MATRIX_CONTENT,
                List.of("cyberpunk", "chosen one", "anime", "keanu", "reality", "philosophy"));
        Document d2 = new Document("Harry Potter and the Prisoner of Azkaban", List.of("Alfonso Cuarón"),  POTTER_CONTENT,
                List.of("wizards", "chosen one", "muggles", "magic", "wands", "voldemort"));

        var documents = List.of(d1, d2);

        // a) Todos los documentos cuyo título sea exactamente igual a un título dado.
        System.out.println(DocumentFilters.titleEquals("The Matrix").filter(documents));
        // b) Todos los documentos cuyo título contenga una palabra o frase dada.
        System.out.println(DocumentFilters.titleContains("Potter").filter(documents));
        // c) Todos los documentos que contengan una palabra clave dada.
        System.out.println(hasKeyword("chosen one").filter(documents));
        // d) Todos los documentos que no contengan ninguna palabra clave.
        System.out.println(DocumentFilters.not(hasAllKeywords(List.of("chosen one", "keanu"))).filter(documents));
        // e) Todos los documentos de un autor determinado.
        System.out.println(DocumentFilters.authoredBy("Alfonso Cuarón").filter(documents));
        // f) Todos los documentos cuyo contenido tenga una palabra o frase dada.
        System.out.println(DocumentFilters.contentContains("Trinity").filter(documents));
        // g) Todos los documentos cuyo contenido tenga al menos 20 palabras.
        System.out.println(DocumentFilters.minContentWords(20).filter(documents));
        // h) Cualquier combinación lógica de las formas anteriores.
        System.out.println(DocumentFilters.and(titleEquals("The Matrix"), hasKeyword("chosen one")).filter(documents));
        System.out.println(DocumentFilters.or(titleEquals("The Matrix"), authoredBy("Alfonso Cuarón")).filter(documents));
    }
}
