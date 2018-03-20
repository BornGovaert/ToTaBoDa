package totaboda.repositories;


import totaboda.author.Author;
import totaboda.author.AuthorRepository;
import totaboda.book.Book;
import totaboda.book.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookRepositoryTest {


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

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
                .doesNotContain(notExpectedBook);
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
    void getBookInformationTitle_givenLetter_Z_returnsListOfBooksContainingLetter_Z(){
        Book expectedBook1 = new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1"));
        Book expectedBook2 = new Book("999", "Zorro", AuthorRepository.getAuthorDatabase().get("4"));
        Book notExpectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = BookRepository.getBookInformationTitle("z");

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
                .doesNotContain(notExpectedBook);
    }

    @Test
    void getBookInformationTitle_givenNonExistentTitle_throwIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BookRepository.getBookInformationTitle("xoxo");
        });

        assertEquals(exception.getMessage(), "No book found for title:xoxo");
    }

    @Test
    void getBooksGivenAuthor_happyPath(){
        Author author = new Author("2", "Dan", "Brown");
        Book expectedBook = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));
        Book notExpectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = BookRepository.getBooksGivenAuthor(author);

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook)
                .doesNotContain(notExpectedBook);
    }

    @Test
    void getBooksGivenAuthor_givenNonExistingAuthor_throwIllegalArgumentException(){
        Author author = new Author("89", "Dag", "Allemal");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BookRepository.getBooksGivenAuthor(author);
        });

        assertEquals(exception.getMessage(), "No books found for author:"+ author);
    }

    @Test
    void getBookGivenPartialAuthor_givenLetter_N_returnsListOfBooksWhereAuthorContainsLetter_N(){
        Book expectedBook1 = new Book("123", "Azkaban", AuthorRepository.getAuthorDatabase().get("1"));
        Book expectedBook2 = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));
        Book notExpectedBook = new Book("666", "Kaas", AuthorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = BookRepository.getBookGivenPartialAuthor("n");

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
                .doesNotContain(notExpectedBook);
    }

    @Test
    void getBookGivenPartialAuthor_givenNonExistentString_throwsIllegalArgumentExceptio(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BookRepository.getBookGivenPartialAuthor("sdjfjkskdf");
        });

        assertEquals(exception.getMessage(), "No books found for author:sdjfjkskdf");
    }

    @Test
    void createBook_happyPath(){
        Book bookToAdd = new Book("testBook", "Serious Book Title", AuthorRepository.getAuthorDatabase().get("1"));

        BookRepository newBookRepo = new BookRepository();
        newBookRepo.createBook("testBook", "Serious Book Title", "Rowling");

        Assertions.assertThat(newBookRepo.getBooks()).contains(bookToAdd);
    }

    @Test
    void createBook_throwsException(){
        Book bookToAdd = new Book("testBook", "Serious Book Title", new Author("64", "Louis", "Armstrong"));

        BookRepository newBookRepo = new BookRepository();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> { newBookRepo.createBook("testBook", "Serious Book Title", "Armstrong");
        });
    }

    @Test
    void deleteBook_happyPath(){
        Book bookToDelete = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));

        BookRepository newBookRepo = new BookRepository();
        BookRepository.deleteBook("111");

        Assertions.assertThat(newBookRepo.getBooks()).doesNotContain(bookToDelete);
    }

    @Test
    void deleteBook_throwsException(){
        Book bookToDelete = new Book("456", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));

        BookRepository newBookRepo = new BookRepository();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> { newBookRepo.deleteBook("456");
        });

    }

    @Test
    void updateBook_happyPath(){
        Book bookOldInfo = new Book("111", "DaVinci", AuthorRepository.getAuthorDatabase().get("2"));
        Book bookNewInfo = new Book("111", "Da Vinci Code", AuthorRepository.getAuthorDatabase().get("2"));

        BookRepository newBookRepo = new BookRepository();
        newBookRepo.updateBook(bookNewInfo);

        Assertions.assertThat(newBookRepo.getBooks())
                .contains(bookNewInfo)
                .doesNotContain(bookOldInfo);
    }

//    @Test
//    void updateBook_throwsException(){
//        Assertions.fail("");
//    }
}
