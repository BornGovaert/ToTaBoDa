package totaboda;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import be.totaboda.Repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BookServiceTest {

//    List<Book> testList = new ArrayList<>();
//    Book book1 = new Book("007", "James Bond", new Author("78", "Ian", "Flemming"));
//    Book book2 = new Book("072", "James Bond 2", new Author("78", "Ian", "Flemming"));
//    Book book3 = new Book("5232ABF", "The History of PingPong", new Author("2", "John", "Smith"));
//
//    @Test
//    void getBookISBN_thenMockCallingMethod(){
//        testList.add(book1);
//        testList.add(book2);
//        testList.add(book3);
//
//        BookService testService = new BookService();
//        //BookRepository testRepo = Mockito.mock(BookRepository.class);
//
//        when(BookRepository.getBookInformationISBN("007")).thenReturn(testList);
//
//        Assertions.assertThat(testService.getBookISBN("007")).isEqualTo(testList);
//       // verify(BookRepository.getBookInformationISBN("007"), times(1));
//    }
//
//    @Test
//    void getBookISBN_givenWrongISBN_thenMockIllegalArgumentException

}