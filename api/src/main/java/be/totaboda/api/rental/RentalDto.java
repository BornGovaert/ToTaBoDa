package be.totaboda.api.rental;

import be.totaboda.domain.rental.RentalRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalDto {

    public int id;
    public int memberId;
    public String bookIsbn;
    public LocalDate startDate;
    public LocalDate returnDate;

    public RentalDto withBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
        return this;
    }

    public RentalDto withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public RentalDto withReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public RentalDto withId(int id) {
        this.id = id;
        return this;
    }

    public RentalDto withMemberId(int memberId) {
        this.memberId = memberId;
        return this;
    }
}
