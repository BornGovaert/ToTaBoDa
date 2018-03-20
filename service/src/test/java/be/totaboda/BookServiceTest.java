package be.totaboda;

import be.totaboda.author.AuthorRepository;
import be.totaboda.book.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import totaboda.BookService;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Test
    public void getBookISBN_givenCompleteExistingIsbnNumber_thenReturnBook() {
        // GIVEN
        BookService bookService = new BookService();

        // WHEN
        List<Book> bookList = bookService.getBookISBN("999");

        // THEN
        assertThat(bookList.get(0).getIsbn()).isEqualTo("999");
        assertThat(bookList.get(0).getTitle()).isEqualTo("Zorro");
        assertThat(bookList.get(0).getAuthor()).isEqualTo(AuthorRepository.getAuthorDatabase().get("4"));
    }


    //GIVEN UNKNOWN ISBN
//    @Test
//    public void getBookISBN_givenAUnknownBookIsbn_thenReturnBookWithUnknownNameAndNoPrice() {
//        // GIVEN
//        BookService bookService = new BookService();
//
//        // WHEN
//        List<Book> actualBookList = bookService.getBookISBN("XXX");
//
//        // THEN
//        assertThat(actualBookList.get(0).getIsbn()).isEqualTo("XXX");
//        assertThat(actualBookList.get(0).getTitle()).isEqualTo("Unknown book");
//        assertThat(actualBookList.get(0).getAuthor()).isNull();
//    }

    @Test
    public void getBookTitle_givenCompleteExistingTitle_thenReturnBook() {
        // GIVEN
        BookService bookService = new BookService();

        // WHEN
        List<Book> bookList = bookService.getBookTitle("Zorro");

        // THEN
        assertThat(bookList.get(0).getIsbn()).isEqualTo("999");
        assertThat(bookList.get(0).getTitle()).isEqualTo("Zorro");
        assertThat(bookList.get(0).getAuthor()).isEqualTo(AuthorRepository.getAuthorDatabase().get("4"));
    }

    @Test
    public void getBookByAuthor_givenAuthor_thenReturnBook() {
        // GIVEN
        BookService bookService = new BookService();

        // WHEN
        List<Book> bookList = bookService.getBookByAuthor(AuthorRepository.getAuthorDatabase().get("4"));

        // THEN
        assertThat(bookList.get(0).getIsbn()).isEqualTo("999");
        assertThat(bookList.get(0).getTitle()).isEqualTo("Zorro");
        assertThat(bookList.get(0).getAuthor()).isEqualTo(AuthorRepository.getAuthorDatabase().get("4"));
    }


}

//
//    private BookRepository mockRepo;
//    private List<Book> testList;
//    private Book book1;
//    private Book book2;
//    private Book book3;
//
//    @BeforeEach
//    void setUp(){
//
//        //MOCKED CLASS
//        mockRepo = mock(BookRepository.class);
//
//        //DATA
//        testList = new ArrayList<>();
//
//        book1 = new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1"));
//        book2 = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));
//        book3 = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

//        testList.add(book1);
//        testList.add(book2);
//        testList.add(book3);



//    @Test
//    void getBookISBN_thenMockCallingMethod(){
//        testList.add(book3);
//        BookService testService = new BookService(mockRepo);
//
//        when(mockRepo.getBookInformationISBN("666")).thenReturn(testList);
//
//        //Assertions.assertThat(testService.getBookISBN("666")).isEqualTo(testList);
//        verify(BookRepository.getBookInformationISBN("666"), times(1));
//    }

