import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        // Otomatis mengambil data lama dari TXT saat aplikasi nyala
        this.books = FileHandler.loadFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}