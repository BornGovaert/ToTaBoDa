package be.totaboda.Repositories;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryTest {


    List<Book> testList;

    public BookRepositoryTest() {
        testList = new ArrayList<>();
    }


    @Test
    void getBookInformationISBN_happyPath(){
        Book expectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));
        Book notExpectedBook = new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1"));

        List<Book> actualBooks = BookRepository.getBookInformationISBN("666");

        Assertions.assertThat(actualBooks).contains(expectedBook);
        Assertions.assertThat(actualBooks).doesNotContain(notExpectedBook);
    }

    @Test
    void getBookInformationISBN_givenISBNumber1_returnsListOfBooksContainingISBNnumber1(){
        Book expectedBook1 = new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1"));
        Book expectedBook2 = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));
        Book notExpectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = BookRepository.getBookInformationISBN("1");

        Assertions.assertThat(actualBooks).contains(expectedBook1, expectedBook2);
        Assertions.assertThat(actualBooks).doesNotContain(notExpectedBook);
    }

    @Test
    void getBookInformationISBN_givenInexistentISBN_throwIllegalArgumentException(){
        
    }


}
