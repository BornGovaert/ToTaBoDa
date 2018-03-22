package be.totaboda.service;

import be.totaboda.domain.author.Author;
import be.totaboda.domain.author.AuthorRepository;
import be.totaboda.domain.book.Book;
import be.totaboda.domain.book.BookRepository;
import be.totaboda.domain.rental.RentalRepository;
import be.totaboda.domain.users.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class RentalServiceTest {

    static RentalService rentalService;
    static AuthorRepository authorRepo;
    static RentalRepository mockRentalRepo;
    static UserRepository mockUserRepo;
    static BookRepository mockBookRepo;
    Book book1;
    Book book2;
    Book book3;

    @BeforeEach
    void setUp(){
        mockBookRepo = mock(BookRepository.class);
        mockRentalRepo = mock(RentalRepository.class);
        mockUserRepo = mock(UserRepository.class);

        rentalService = new RentalService(mockUserRepo, mockRentalRepo, mockBookRepo);
    }

    @Test
    void createRental_happyPath() {
        rentalService.createRental(1, "111");
        verify(mockRentalRepo, times (1)).createRental(1,"111");
    }
}