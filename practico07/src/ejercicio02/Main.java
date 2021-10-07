package ejercicio02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 2 - Vocabulario
 * Se desean llevar las estadísticas del vocabulario de un texto. El constructor de esta clase
 * recibe como parámetro un String y crea los objetos necesarios para saber qué palabras
 * aparecen en el mismo y cuántas veces. Se debe permitir:
 * 1. Conocer la cantidad de palabras diferentes que contiene el texto.
 * 2. Retornar las N palabras más frecuentes.
 * 3. Retornar las N palabras menos frecuentes.
 * 4. Obtener la frecuencia de ocurrencia de una palabra.
 * 5. Obtener un listado de palabras ordenadas ascendentemente.
 * 6. Obtener un listado de palabras ordenadas por frecuencia.
 *
 * Nota: para separar las palabras del string recibido como parámetro del constructor, se puede
 * utilizar el método “split” de la clase String, que recibe como parámetro una expresión regular
 * por la que dividir el string y retorna un arreglo con las paradas separadas por dicha expresión
 *
 * String[] arreloDeStrings = texto.split(" ");
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "practico07/resources/Constitucion.md";
        Path pathToFile = Paths.get(filename);
        TextParser tp = new TextParser(Files.readString(pathToFile, StandardCharsets.UTF_8));
        // Conocer la cantidad de palabras diferentes que contiene el texto.
        System.out.println("El texto tiene " + tp.getWordCount() + " palabras.");
        // Renornar las N palabras más frecuentes
        System.out.println("Las 10 palabras más frecuentes son " + tp.getTop(10));
        // Renornar las N palabras menos frecuentes
        System.out.println("Las 10 palabras menos frecuentes son " + tp.getLast(10));
        // Obtener la frecuencia de ocurrencia de una palabra
        System.out.println("La palabra 'Justicia' aparece " + tp.getOccurrences("Justicia") + " veces.");
        System.out.println("La palabra 'Libertad' aparece " + tp.getOccurrences("Libertad") + " veces.");
        System.out.println("La palabra 'Naturaleza' aparece " + tp.getOccurrences("Naturaleza") + " veces.");
        System.out.println("La palabra 'Impuesto' aparece " + tp.getOccurrences("Impuesto") + " veces.");
        System.out.println("La palabra 'Dios' aparece " + tp.getOccurrences("Dios") + " veces.");
        System.out.println("La palabra 'Amor' aparece " + tp.getOccurrences("Amor") + " veces.");
        System.out.println("La palabra 'Perón' aparece " + tp.getOccurrences("Perón") + " veces.");
        System.out.println("La palabra 'Cambio' aparece " + tp.getOccurrences("Cambio") + " veces.");
        System.out.println("La palabra 'Trabajadores' aparece " + tp.getOccurrences("Trabajadores") + " veces.");
        System.out.println("La palabra 'Pueblo' aparece " + tp.getOccurrences("Pueblo") + " veces.");
        // Obtener un listado de palabras ordenadas ascendentemente
        System.out.println("La palabras ascendentemente son " + tp.getSortedWords());
        // Obtener un listado de palabras ordenadas por frecuencia
        System.out.println("La palabras por orden de occurencia son " + tp.getWordsSortedByOccurrences());
    }
}
