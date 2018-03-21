package totaboda.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import totaboda.BookService;
import totaboda.book.Book;
import totaboda.dtos.BookDto;
import totaboda.mapper.BookMapper;

import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private BookService bookService;

    @Inject
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooks(){
        ArrayList<BookDto> booksDto = new ArrayList<>();
        for (Book book : bookService.getBooks()){
            booksDto.add(BookMapper.bookMapper(book));
        }
        return booksDto;
    }

    @GetMapping(path = "/isbn/{isbn}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByIsbn(@PathVariable String isbn){
        ArrayList<BookDto> booksByIsbn = new ArrayList<>();
        List<Book> booksFoundMatchingIsbn = bookService.getBookISBN(isbn);
        for(Book book : booksFoundMatchingIsbn){
            booksByIsbn.add(BookMapper.bookMapper(book));
        }
        return booksByIsbn;
    }
    @GetMapping(path = "/title/{title}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByTitle(@PathVariable String title){
        ArrayList<BookDto> booksByTitle = new ArrayList<>();
        List<Book> booksFoundMatchingTitle = bookService.getBookTitle(title);
        for(Book book : booksFoundMatchingTitle){
            booksByTitle.add(BookMapper.bookMapper(book));
        }
        return booksByTitle;
    }

    @GetMapping(path = "/author/{author}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByAuthor(@PathVariable String author){
        ArrayList<BookDto> booksByAuthor = new ArrayList<>();
        List<Book> booksFoundMatchingAuthor = bookService.getBookByAuthor(author);
        for(Book book : booksFoundMatchingAuthor){
            booksByAuthor.add(BookMapper.bookMapper(book));
        }
        return booksByAuthor;
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable("book") String isbn) {
        bookService.deleteBook(isbn);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

}
