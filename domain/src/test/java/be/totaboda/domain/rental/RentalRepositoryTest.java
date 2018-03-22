package be.totaboda.domain.rental;

import be.totaboda.domain.book.BookRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.Before;
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
        rentalRepo.createRental("791101 199 53", "666");

        Assertions.assertThat(rentalRepo.getLentBooks().get(0))
                .hasFieldOrPropertyWithValue("memberInss", "791101 199 53")
                .hasFieldOrPropertyWithValue("bookIsbn", "666");
    }


    @Test
    void createRental_givenWrongMemberINSS_throwException() {

    }


    @Test
    void createRental_givenWrongBookISBN_throwException() {
    }


//    @Test
//    void createRental_givenUnavailableBook_throwException() {
//    }

    @Test
    void createRental_givenMaxOf9RentalsPerMember_throwException(){

    }


}