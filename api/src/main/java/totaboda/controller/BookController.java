package totaboda.controller;

import be.totaboda.book.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import totaboda.BookService;
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

    @GetMapping(path = "/{isbn}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBookByIsbn(String isbn){
        ArrayList<BookDto> booksByIsbn = new ArrayList<>();
        List<Book> booksFoundMatchingIsbn = bookService.getBookISBN(isbn);
        for(Book book : booksFoundMatchingIsbn){
            booksByIsbn.add(BookMapper.bookMapper(book));
        }
        return booksByIsbn;
    }
}
