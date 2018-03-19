package totaboda;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import be.totaboda.Repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookService {

    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());

    public List<Book> getBooks() {
        return BookRepository.getBooks();
    }

    public List<Book> getBook(String isbn) {
        try {
            return BookRepository.getBookInformation(isbn);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> testList = new ArrayList<>();
            testList.add(new Book(isbn, "Unknown Title", new Author("Unknown id", "Unknownd FirstName", "Unknown Lastname")));
            return testList;
        }
    }

}
