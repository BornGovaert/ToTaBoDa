package be.totaboda.service;

import be.totaboda.domain.book.BookRepository;
import be.totaboda.domain.rental.RentalRepository;
import be.totaboda.domain.users.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RentalServiceTest {

    static RentalService rentalService;
    static RentalRepository mockRentalRepo;
    static UserRepository mockUserRepo;
    static BookRepository mockBookRepo;

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

    @Test
    void createRental_givenIncorrectBookIsbn_hrowException(){
        doThrow(new IllegalArgumentException("Please provide valid id or isbn")).when(mockRentalRepo).createRental(1, "555");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> {
            rentalService.createRental(1, "555");
        });
    }

    @Test
    void createRental_givenIncorrectMemberInss_throwException(){
        doThrow(new IllegalArgumentException("Please provide valid id or isbn")).when(mockRentalRepo).createRental(10, "111");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> {
            rentalService.createRental(10, "111");
        });
    }


}