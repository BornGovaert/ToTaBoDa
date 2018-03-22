package be.totaboda.service;

import be.totaboda.domain.author.Author;
import be.totaboda.domain.book.Book;
import be.totaboda.domain.book.BookRepository;
import be.totaboda.service.exceptions.LibraryException;
import be.totaboda.service.exceptions.UnknownResourceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
public class BookService {

    private BookRepository bookRepository;
    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());

    @Inject
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public List<Book> getBookISBN(String isbn) {
        try {
            return bookRepository.getBookInformationISBN(isbn);
        } catch (IllegalArgumentException e) {
            throw new UnknownResourceException("Book", "ISBN NR: " + isbn);
        }
    }

    public List<Book> getBookTitle(String title){
        try {
            return bookRepository.getBookInformationTitle(title);
        } catch (IllegalArgumentException e) {
            throw new UnknownResourceException("Book", "Title: " + title);
        }
    }

    public List<Book> getBookByAuthor(String author){
        try {
            return bookRepository.getBooksGivenAuthor(author);
        } catch (Exception e) {
            throw new UnknownResourceException("Book", "Title: " + author);
        }
    }

    public Book createBook(Book book){
        if(doesBookAlreadyExist(book)){
            throw new LibraryException("This book is already in the Digibooky Database");
        }
        return bookRepository.createBook(book);
    }

    public Book updateBook(Book book) {
       bookRepository.updateBook(book);
       return book;
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteBook(isbn);
    }
    public boolean doesBookAlreadyExist(Book book){
        return bookRepository.getBooks().contains(book);
    }

}



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
