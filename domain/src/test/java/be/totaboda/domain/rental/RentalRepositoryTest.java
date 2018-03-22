package be.totaboda.domain.rental;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalRepositoryTest {

    RentalRepository rentalRepo;

    @BeforeEach
    void setUp(){
        rentalRepo = new RentalRepository();
    }


    @Test
    void createRental_happyPath() {
        rentalRepo.createRental(1,"666");

        Assertions.assertThat(rentalRepo.getLentBooks().get(0))
                .hasFieldOrPropertyWithValue("memberId", 1)
                .hasFieldOrPropertyWithValue("bookIsbn", "666");
    }


//    @Test
//    void createRental_givenWrongMemberINSS_throwException() {
//        Assertions.fail("to be implemented");
//    }
//
//
//    @Test
//    void createRental_givenWrongBookISBN_throwException() {
//        Assertions.fail("to be implemented");
//    }


    @Test
    void createRental_givenUnavailableBook_throwException() {
        rentalRepo.createRental(1, "123");
        rentalRepo.createRental(2, "666");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
        -> {
            rentalRepo.createRental(2, "123");
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("This book is already rented out");
    }

    @Test
    void createRental_givenMaxOf2RentalsPerMember_throwException(){
        rentalRepo.createRental(1, "123");
        rentalRepo.createRental(1, "666");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
        -> {
            rentalRepo.createRental(1, "111");
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("You can only rent 2 bookS.");
    }


}