package totaboda;

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
    private AuthorRepository authorRepository = new AuthorRepository();
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

    @Test
    public void getBookISBN_whenGivingIsbn_ReturnBook() {
        ArrayList<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book1);
        Mockito.when(mockRepository.getBookInformationISBN("111")).thenReturn(expectedBooks);
        assertThat(bookService.getBookISBN("111")).isEqualTo(expectedBooks);
    }

    @Test
    public void getBookISBN_whenGivingPartialIsbn_ReturnBook() {
        ArrayList<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book1);
        expectedBooks.add(book2);
        Mockito.when(mockRepository.getBookInformationISBN("1")).thenReturn(expectedBooks);
        assertThat(bookService.getBookISBN("1")).isEqualTo(expectedBooks);
    }

    @Test
    public void getBookTitle_whenATitleIsGiven_ReturnBook() {
        ArrayList<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book3);
        Mockito.when(mockRepository.getBookInformationTitle("Kaas")).thenReturn(expectedBooks);
        assertThat(bookService.getBookTitle("Kaas")).isEqualTo(expectedBooks);
    }

    @Test
    public void getBookTitle_whenAPartialTitleIsGiven_ReturnBook() {
        ArrayList<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book3);
        Mockito.when(mockRepository.getBookInformationTitle("Ka")).thenReturn(expectedBooks);
        assertThat(bookService.getBookTitle("Ka")).isEqualTo(expectedBooks);
    }

    @Test
    public void getBookTitle_whenAPartialTitleIsGiven_ReturnBooksWithPartialTitle() {
        ArrayList<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book1);
        expectedBooks.add(book2);
        Mockito.when(mockRepository.getBookInformationTitle("n")).thenReturn(expectedBooks);
        assertThat(bookService.getBookTitle("n")).isEqualTo(expectedBooks);
    }

}







