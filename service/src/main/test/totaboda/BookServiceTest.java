package totaboda;

import be.totaboda.Book.Author;
import be.totaboda.Book.Book;
import be.totaboda.Repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookServiceTest {

    Book testBook = new Book("007", "James Bond", new Author("78", "Ian", "Flemming"));

    @Test
    void getBook_givenISBN_happyPath(){
        BookService testService = new BookService();
        BookRepository testRepo = Mockito.mock(BookRepository.class);

        when(testRepo.getBookInformation("007")).thenReturn(testBook);

        Assertions.assertThat(testService.getBook("007")).isEqualTo(testBook);
    }

}