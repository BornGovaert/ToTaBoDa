package totaboda;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import be.totaboda.Repositories.AuthorRepository;
import be.totaboda.Repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private BookRepository mockRepo;
    private List<Book> testList;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp(){

        //MOCKED CLASS
        mockRepo = mock(BookRepository.class);

        //DATA
        testList = new ArrayList<>();

        book1 = new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1"));
        book2 = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));
        book3 = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

//        testList.add(book1);
//        testList.add(book2);
//        testList.add(book3);
    }


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

}