public class Book {
    private final String author;
    private final String title;
    private final String isbn;
    private final int id;

    public Book(String author, String title, String isbn, int id) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return author + "; " + title + "; isbn " + isbn + "; (" + id + ")";
    }
}
