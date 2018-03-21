
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

    private BookRepository bookRepository = new BookRepository();
    private AuthorRepository authorRepository  = new AuthorRepository();

    @Test
    void getBookInformationISBN_happyPath(){
        Book expectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = bookRepository.getBookInformationISBN("666");

        Assertions.assertThat(actualBooks).containsExactly(expectedBook);
    }

    @Test
    void getBookInformationISBN_givenISBNumber1_returnsListOfBooksContainingISBNnumber1(){
        Book expectedBook1 = new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
        Book expectedBook2 = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = bookRepository.getBookInformationISBN("1");

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
                .doesNotContain(notExpectedBook);
    }

    @Test
    void getBookInformationISBN_givenNonExistentISBN_throwIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
           bookRepository.getBookInformationISBN("xoxo");
        });

        assertEquals(exception.getMessage(), "No book found for isbn:xoxo");
    }

    @Test
    void getBookInformationTitle_happyPath(){
        Book expectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = bookRepository.getBookInformationTitle("Kaas");

        Assertions.assertThat(actualBooks).containsExactly(expectedBook);
    }

    @Test
    void getBookInformationTitle_givenLetter_Z_returnsListOfBooksContainingLetter_Z(){
        Book expectedBook1 = new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
        Book expectedBook2 = new Book("999", "Zorro", authorRepository.getAuthorDatabase().get("4"));
        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = bookRepository.getBookInformationTitle("z");

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
                .doesNotContain(notExpectedBook);
    }

    @Test
    void getBookInformationTitle_givenNonExistentTitle_throwIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bookRepository.getBookInformationTitle("xoxo");
        });

        assertEquals(exception.getMessage(), "No book found for title:xoxo");
    }

    @Test
    void getBooksGivenAuthor_happyPath(){
       String author = "Dan_Brown";
        Book expectedBook = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = bookRepository.getBooksGivenAuthor(author);

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook)
                .doesNotContain(notExpectedBook);
    }

    @Test
    void getBooksGivenAuthor_givenNonExistingAuthor_throwIllegalArgumentException(){
       String author = "Dag Allemal";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bookRepository.getBooksGivenAuthor(author);
        });

        assertEquals(exception.getMessage(), "No books found for author:"+ author);
    }

    @Test
    void getBookGivenPartialAuthor_givenLetter_N_returnsListOfBooksWhereAuthorContainsLetter_N(){
        Book expectedBook1 = new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
        Book expectedBook2 = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));

        List<Book> actualBooks = bookRepository.getBooksGivenAuthor("n");

        Assertions.assertThat(actualBooks)
                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
                .doesNotContain(notExpectedBook);
    }

    @Test
    void getBookGivenPartialAuthor_givenNonExistentString_throwsIllegalArgumentExceptio(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bookRepository.getBooksGivenAuthor("sdjfjkskdf");
        });

        assertEquals(exception.getMessage(), "No books found for author:sdjfjkskdf");
    }

    @Test
    void createBook_happyPath(){
        Book bookToAdd = new Book("testBook", "Serious Book Title", authorRepository.getAuthorDatabase().get("1"));

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
        Book bookToDelete = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));

        BookRepository newBookRepo = new BookRepository();
        bookRepository.deleteBook("111");

        Assertions.assertThat(newBookRepo.getBooks()).doesNotContain(bookToDelete);
    }

    @Test
    void deleteBook_throwsException(){
        Book bookToDelete = new Book("456", "DaVinci", authorRepository.getAuthorDatabase().get("2"));

        BookRepository newBookRepo = new BookRepository();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> { newBookRepo.deleteBook("456");
        });

    }

    @Test
    void updateBook_happyPath(){
        Book bookOldInfo = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
        Book bookNewInfo = new Book("111", "Da Vinci Code", authorRepository.getAuthorDatabase().get("2"));

        BookRepository newBookRepo = new BookRepository();
        newBookRepo.updateBook(bookNewInfo);

        Assertions.assertThat(newBookRepo.getBooks())
                .contains(bookNewInfo)
                .doesNotContain(bookOldInfo);
    }

}


//package totaboda.repositories;
//
//
//import totaboda.author.Author;
//import totaboda.author.AuthorRepository;
//import totaboda.book.Book;
//import totaboda.book.BookRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class BookRepositoryTest {
//
//    private BookRepository bookRepository;
//    private AuthorRepository authorRepository;
//
//    @Test
//    void getBookInformationISBN_happyPath(){
//        Book expectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));
//
//        List<Book> actualBooks = bookRepository.getBookInformationISBN("666");
//
//        Assertions.assertThat(actualBooks).containsExactly(expectedBook);
//    }
//
//    @Test
//    void getBookInformationISBN_givenISBNumber1_returnsListOfBooksContainingISBNnumber1(){
//        Book expectedBook1 = new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
//        Book expectedBook2 = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
//        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));
//
//        List<Book> actualBooks = bookRepository.getBookInformationISBN("1");
//
//        Assertions.assertThat(actualBooks)
//                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
//                .doesNotContain(notExpectedBook);
//    }
//
//    @Test
//    void getBookInformationISBN_givenNonExistentISBN_throwIllegalArgumentException(){
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//           bookRepository.getBookInformationISBN("xoxo");
//        });
//
//        assertEquals(exception.getMessage(), "No book found for isbn:xoxo");
//    }
//
//    @Test
//    void getBookInformationTitle_happyPath(){
//        Book expectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));
//
//        List<Book> actualBooks = bookRepository.getBookInformationTitle("Kaas");
//
//        Assertions.assertThat(actualBooks).containsExactly(expectedBook);
//    }
//
//    @Test
//    void getBookInformationTitle_givenLetter_Z_returnsListOfBooksContainingLetter_Z(){
//        Book expectedBook1 = new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
//        Book expectedBook2 = new Book("999", "Zorro", authorRepository.getAuthorDatabase().get("4"));
//        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));
//
//        List<Book> actualBooks = bookRepository.getBookInformationTitle("z");
//
//        Assertions.assertThat(actualBooks)
//                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
//                .doesNotContain(notExpectedBook);
//    }
//
//    @Test
//    void getBookInformationTitle_givenNonExistentTitle_throwIllegalArgumentException(){
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//            bookRepository.getBookInformationTitle("xoxo");
//        });
//
//        assertEquals(exception.getMessage(), "No book found for title:xoxo");
//    }
//
//    @Test
//    void getBooksGivenAuthor_happyPath(){
//        Author author = new Author("2", "Dan", "Brown");
//        Book expectedBook = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
//        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));
//
//        List<Book> actualBooks = bookRepository.getBooksGivenAuthor(author);
//
//        Assertions.assertThat(actualBooks)
//                .containsExactlyInAnyOrder(expectedBook)
//                .doesNotContain(notExpectedBook);
//    }
//

//    @Test
//    void getBookGivenPartialAuthor_givenLetter_N_returnsListOfBooksWhereAuthorContainsLetter_N(){
//        Book expectedBook1 = new Book("123", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
//        Book expectedBook2 = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
//        Book notExpectedBook = new Book("666", "Kaas", authorRepository.getAuthorDatabase().get("3"));
//
//        List<Book> actualBooks = bookRepository.getBookGivenPartialAuthor("n");
//
//        Assertions.assertThat(actualBooks)
//                .containsExactlyInAnyOrder(expectedBook1, expectedBook2)
//                .doesNotContain(notExpectedBook);
//    }

//    @Test
//    void getBookGivenPartialAuthor_givenNonExistentString_throwsIllegalArgumentExceptio(){
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//            bookRepository.getBookGivenPartialAuthor("sdjfjkskdf");
//        });
//
//        assertEquals(exception.getMessage(), "No books found for author:sdjfjkskdf");
//    }
//
//    @Test
//    void createBook_happyPath(){
//        Book bookToAdd = new Book("testBook", "Serious Book Title", authorRepository.getAuthorDatabase().get("1"));
//
//        BookRepository newBookRepo = new BookRepository();
//        newBookRepo.createBook("testBook", "Serious Book Title", "Rowling");
//
//        Assertions.assertThat(newBookRepo.getBooks()).contains(bookToAdd);
//    }
//
//    @Test
//    void createBook_throwsException(){
//        Book bookToAdd = new Book("testBook", "Serious Book Title", new Author("64", "Louis", "Armstrong"));
//
//        BookRepository newBookRepo = new BookRepository();
//
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
//                -> { newBookRepo.createBook("testBook", "Serious Book Title", "Armstrong");
//        });
//    }
//
//    @Test
//    void deleteBook_happyPath(){
//        Book bookToDelete = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
//
//        BookRepository newBookRepo = new BookRepository();
//        bookRepository.deleteBook("111");
//
//        Assertions.assertThat(newBookRepo.getBooks()).doesNotContain(bookToDelete);
//    }
//
//    @Test
//    void deleteBook_throwsException(){
//        Book bookToDelete = new Book("456", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
//
//        BookRepository newBookRepo = new BookRepository();
//
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
//                -> { newBookRepo.deleteBook("456");
//        });
//
//    }
//
//    @Test
//    void updateBook_happyPath(){
//        Book bookOldInfo = new Book("111", "DaVinci", authorRepository.getAuthorDatabase().get("2"));
//        Book bookNewInfo = new Book("111", "Da Vinci Code", authorRepository.getAuthorDatabase().get("2"));
//
//        BookRepository newBookRepo = new BookRepository();
//        newBookRepo.updateBook(bookNewInfo);
//
//        Assertions.assertThat(newBookRepo.getBooks())
//                .contains(bookNewInfo)
//                .doesNotContain(bookOldInfo);
//    }
//
//}

