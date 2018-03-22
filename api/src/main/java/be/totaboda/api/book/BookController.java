package be.totaboda.api.book;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import be.totaboda.service.BookService;
import be.totaboda.domain.book.Book;

import javax.inject.Inject;
import java.util.ArrayList;
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
            booksDto.add(BookMapper.bookToDto(book));
        }
        return booksDto;
    }

    @GetMapping(path = "/isbn/{isbn}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByIsbn(@PathVariable String isbn){
        ArrayList<BookDto> booksByIsbn = new ArrayList<>();
        List<Book> booksFoundMatchingIsbn = bookService.getBookISBN(isbn);
        for(Book book : booksFoundMatchingIsbn){
            booksByIsbn.add(BookMapper.bookToDto(book));
        }
        return booksByIsbn;
    }
    @GetMapping(path = "/title/{title}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByTitle(@PathVariable String title){
        ArrayList<BookDto> booksByTitle = new ArrayList<>();
        List<Book> booksFoundMatchingTitle = bookService.getBookTitle(title);
        for(Book book : booksFoundMatchingTitle){
            booksByTitle.add(BookMapper.bookToDto(book));
        }
        return booksByTitle;
    }

    @GetMapping(path = "/author/{author}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByAuthor(@PathVariable String author){
        ArrayList<BookDto> booksByAuthor = new ArrayList<>();
        List<Book> booksFoundMatchingAuthor = bookService.getBookByAuthor(author);
        for(Book book : booksFoundMatchingAuthor){
            booksByAuthor.add(BookMapper.bookToDto(book));
        }
        return booksByAuthor;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto book){
        return BookMapper.bookToDto(bookService.createBook(BookMapper.dtoToBook(book)));
    }

    @DeleteMapping(path ="/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }

    @PutMapping(path="/{isbn}",consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable String ISBN, @RequestBody BookDto bookdto) {
       return BookMapper.bookToDto(bookService.updateBook(BookMapper.dtoToBook(bookdto)));
    }
}
