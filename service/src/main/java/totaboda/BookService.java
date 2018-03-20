package totaboda;

import be.totaboda.author.Author;
import be.totaboda.book.Book;
import be.totaboda.book.BookRepository;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
public class BookService {

    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());

    public List<Book> getBooks() {
        return BookRepository.getBooks();
    }

    public List<Book> getBookISBN(String isbn) {
        try {
            return BookRepository.getBookInformationISBN(isbn);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book(isbn, "Unknown Title", new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
            return bookList;
        }
    }

    public List<Book> getBookTitle(String title){
        try {
            return BookRepository.getBookInformationTitle(title);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("Unknown ISBN", title, new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
            return bookList;
        }
    }

    public List<Book> getBookbyAuthor(Author author){
        try {
            return BookRepository.getBooksGivenAuthor(author);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("Unknown ISBN", "Unknown Title", new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
            return bookList;
        }
    }

    public List<Book> getBookGivenPartialAuthorName(String partialAuthorName){
        try {
            return BookRepository.getBookGivenPartialAuthor(partialAuthorName);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("Unknown ISBN", "Unknown Title", new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
            return bookList;
        }
    }
}
