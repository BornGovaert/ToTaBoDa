package totaboda;

import totaboda.author.Author;
import totaboda.book.Book;
import totaboda.book.BookRepository;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
public class BookService {

    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());
    private BookRepository bookRepository = new BookRepository();

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public List<Book> getBookISBN(String isbn) {
        try {
            return bookRepository.getBookInformationISBN(isbn);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book(isbn, "Unknown Title", new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
            return bookList;
        }
    }

    public List<Book> getBookTitle(String title){
        try {
            return bookRepository.getBookInformationTitle(title);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("Unknown ISBN", title, new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
            return bookList;
        }
    }

    public List<Book> getBookByAuthor(String author){
        try {
            return bookRepository.getBooksGivenAuthor(author);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("Unknown ISBN", "Unknown Title", new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
            return bookList;
        }
    }}

//    public List<Book> getBookGivenPartialAuthorName(String partialAuthorName){
//        try {
//            return bookRepository.getBookGivenPartialAuthor(partialAuthorName);
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, e.getMessage());
//            List<Book> bookList = new ArrayList<>();
//            bookList.add(new Book("Unknown ISBN", "Unknown Title", new Author("Unknown id", "Unknown FirstName", "Unknown LastName")));
//            return bookList;
//        }
//    }
//}
