package ejercicio03;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int year;
    private String genre;

    public Book(String isbn, String name, String author, int year, String genre) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
