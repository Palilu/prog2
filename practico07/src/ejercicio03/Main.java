package ejercicio03;

import java.util.Comparator;
import java.util.List;

/**
 * Una biblioteca posee un sistema para la administración de libros disponibles para sus socios.
 * El sistema debe permitir ordenar el conjunto de todos los libros disponibles por diferentes
 * criterios, acorde a lo que desee buscar en un determinado momento. Por defecto, los libros se
 * ordenan por ISBN, un código identificatorio único de cada libro. Sin embargo, es posible que
 * el administrador de la biblioteca desee ordenarlos por autor, año de edición o género
 * principal, tanto ascendente como descendentemente. Resolver el problema utilizando el
 * método sort(.), de la clase Collections.
 */
public class Main {

    public static void main(String[] args) {
        Book b1 = new Book("1", "Tropic of cancer", "Henry Miller", 1934, "Novel");
        Book b2 = new Book("2", "Tropic of capricorn", "Henry Miller", 1939, "Novel");
        Book b3 = new Book("3", "Slaughterhouse-Five", "Kurt Vonnegut", 1969, "Novel");
        Book b4 = new Book("4", "Cat's Cradle", "Kurt Vonnegut", 1963, "Novel");

        var books = List.of(b1, b2, b3, b4);

        BookSorter sorter = new BookSorter();

        imprimir("ISBN", sorter.sort(books));
        imprimir("Nombre", sorter.sort(books, Comparator.comparing(Book::getName)));
        imprimir("Autor", sorter.sort(books, Comparator.comparing(Book::getAuthor)));
        imprimir("Año de edición", sorter.sort(books, Comparator.comparing(Book::getYear)));
        imprimir("Género principal", sorter.sort(books, Comparator.comparing(Book::getGenre)));
        imprimir("ISBN descendiente", sorter.sort(books, Comparator.comparing(Book::getIsbn).reversed()));
        imprimir("Nombre descendiente", sorter.sort(books, Comparator.comparing(Book::getName).reversed()));
        imprimir("Autor descendiente", sorter.sort(books, Comparator.comparing(Book::getAuthor).reversed()));
        imprimir("Año de edición descendiente", sorter.sort(books, Comparator.comparing(Book::getYear).reversed()));
        imprimir("Género principal descendiente", sorter.sort(books, Comparator.comparing(Book::getGenre).reversed()));
    }

    private static void imprimir(String criteria, List<Book> books) {
        System.out.println("Los libros ordenados por " + criteria + " son:");
        books.forEach(System.out::println);
    }
}
