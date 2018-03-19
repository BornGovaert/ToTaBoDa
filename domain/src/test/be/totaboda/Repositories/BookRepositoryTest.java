package be.totaboda.Repositories;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookRepositoryTest {


    List<Book> testList;

    public BookRepositoryTest() {
        testList = new ArrayList<>();
    }


    @Test
    void getBookInformationISBN_happyPath(){
        Book expectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = BookRepository.getBookInformationISBN("666");

        Assertions.assertThat(actualBooks).containsExactly(expectedBook);
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
    void getBookInformationISBN_givenNonExistentISBN_throwIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
           BookRepository.getBookInformationISBN("xoxo");
        });

        assertEquals(exception.getMessage(), "No book found for isbn:xoxo");
    }

    @Test
    void getBookInformationTitle_happyPath(){
        Book expectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = BookRepository.getBookInformationTitle("Kaas");

        Assertions.assertThat(actualBooks).containsExactly(expectedBook);
    }

    @Test
    void getBookInformationTitle_givenLetter_N_returnsListOfBooksContainingLetter_N(){
        Book expectedBook1 = new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1"));
        Book expectedBook2 = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));
        Book notExpectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = BookRepository.getBookInformationISBN("n");

        Assertions.assertThat(actualBooks).contains(expectedBook1, expectedBook2);
        Assertions.assertThat(actualBooks).doesNotContain(notExpectedBook);
    }

    @Test
    void getBookInformationTitle_givenNonExistentTitle_throwIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BookRepository.getBookInformationTitle("xoxo");
        });

        assertEquals(exception.getMessage(), "No book found for title:xoxo");
    }

    @Test
    void getBookGivenPartialAuthor_happyPath(){

    }

}
