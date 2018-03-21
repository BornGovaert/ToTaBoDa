package totaboda;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import totaboda.author.Author;
import totaboda.author.AuthorRepository;
import totaboda.book.Book;
import totaboda.book.BookRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookRepository mockRepository;
    private BookService bookService;
    private AuthorRepository authorRepository;
    private List<Book> testList;
    private Book book1;
    private Book book2;
    private Book book3;



    @BeforeEach
    void setUp() {

        //MOCKED CLASS
        mockRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(mockRepository);
        //DATA
        testList = new ArrayList<>();

        book1 = new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
        book2 = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
        book3 = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));

        testList.add(book1);
        testList.add(book2);
        testList.add(book3);
    }

// @Test
//    public void getUser_happyPath() {
//        Mockito.when(mockRepository.getUserById(0)).thenReturn(member1);
//        Mockito.when(mockRepository.assertThatUserExist(0)).thenReturn(true);
//        Assertions.assertThat(userService.getUser(0)).isEqualTo(member1);
//    }

    @Test
    public void getBooks_given3Books_thenReturnListOf3Books() {
        ArrayList<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("111", "Azkaban", new Author("111", "JK", "Rowling")));
        expectedBooks.add(new Book("121", "Azkaban2", new Author("121", "JK", "Rowling")));
        expectedBooks.add(new Book("131", "Azkaban3", new Author("131", "JK", "Rowling")));
        when(mockRepository.getBooks()).thenReturn(expectedBooks);
        List<Book> actualBooks = bookService.getBooks();
        assertThat(actualBooks).containsExactly(expectedBooks.toArray(new Book[3]));
    }

    @Test
    public void getBooks_happyPath() {
        Mockito.when(mockRepository.getBooks()).thenReturn(testList);
      assertThat(bookService.getBooks()).isEqualTo(testList);
    }


    //-----------------------------------------------------------------------------
//    @Test
//    public void getBookISBN_happyPath() {
//        List<Book> returns = new ArrayList<>();
//        returns.add(book2);
//        Mockito.when(bookRepository.getBookInformationISBN("111")).thenReturn(returns);
//        Assertions.assertThat(bookService.getBookISBN("111")).isEqualTo(returns);
//    }
//
//    @Test
//    public void getBookTitle_happyPath() {
//        List<Book> returns = new ArrayList<>();
//        returns.add(book3);
//        Mockito.when(bookRepository.getBookInformationTitle("Kaas")).thenReturn(returns);
//        Assertions.assertThat(bookService.getBookISBN("Kaas")).isEqualTo(returns);
//    }
//
//    @Test
//    public void getBookByAuthor_happyPath() {
//        List<Book> returns = new ArrayList<>();
//        returns.add(book1);
//        Mockito.when(bookRepository.getBooksGivenAuthor(new Author("1", "JK", "Rowling"))).thenReturn(returns);
//        Assertions.assertThat(bookService.getBookByAuthor(new Author("1", "JK", "Rowling"))).isEqualTo(returns);
//    }
//
//    @Test
//    public void getBookGivenPartialAuthorName_happyPath() {
//        List<Book> returns = new ArrayList<>();
//        returns.add(book2);
//        Mockito.when(bookRepository.getBookGivenPartialAuthor("brow")).thenReturn(returns);
//        Assertions.assertThat(bookService.getBookGivenPartialAuthorName("brow")).isEqualTo(returns);
//    }
}






