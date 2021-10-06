package ejercicio03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSorter {

    private static final Comparator<Book> DEFAULT = Comparator.comparing(Book::getIsbn);

    public List<Book> sort(List<Book> books) {
        return sort(books, DEFAULT);
    }

    public List<Book> sort(List<Book> books, Comparator<Book> comparator) {
        var result = new ArrayList<>(books);
        Collections.sort(result, comparator);
        return result;
    }
}
