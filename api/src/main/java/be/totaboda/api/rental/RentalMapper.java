package be.totaboda.api.rental;

import be.totaboda.domain.rental.Rental;


public class RentalMapper {

    public static RentalDto rentalToDto(Rental rentalToMap){
        return new RentalDto()
                .withId(rentalToMap.getId())
                .withBookIsbn(rentalToMap.getBookIsbn())
                .withMemberId(rentalToMap.getMemberId())
                .withReturnDate(rentalToMap.getReturnDate())
                .withStartDate(rentalToMap.getStartDate());
    }

    public static Rental dtoToRental(RentalDto rental) {
        return new Rental(rental.id, rental.bookIsbn);
    }
}
