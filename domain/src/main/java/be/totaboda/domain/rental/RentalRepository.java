package be.totaboda.domain.rental;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@Named
public class RentalRepository {

    private ArrayList<Rental> lentBooks;
    private static int counterId;
    private int amountOfRentals;

    @Inject
    public RentalRepository() {
        this.lentBooks = new ArrayList<>();
    }

    public RentalRepository(ArrayList<Rental> lentBooks) {
        this.lentBooks = lentBooks;
    }

    public Rental createRental(int memberId, String bookIsbn) {
        counterId++;
        Rental rentalObject = new Rental(memberId, bookIsbn);
        for (Rental newBook : lentBooks) {
            if (newBook.getMemberId() == memberId) {
                amountOfRentals++;
            } else if (newBook.getBookIsbn().equals(bookIsbn)) {
                throw new IllegalArgumentException("This book is already rented out");    //NEEDS CUSTOM EXCEPTIONS
            } else if (amountOfRentals > 2) {
                throw new IllegalArgumentException("You can only rent 9 books.");
            }
        }
        lentBooks.add(rentalObject);
        return rentalObject;
    }

    public void returnBook(int id) {
        for (Rental rental : lentBooks) {
            if (rental.getId() == id) {
                if (LocalDate.now().isAfter(rental.getReturnDate())) {
                    throw new IllegalArgumentException("Book is late");
                } else {
                    lentBooks.remove(rental);
                }
            } else {
                throw new IllegalArgumentException("No book found with that id");
            }
        }
    }

    public static int getCounterId() {
        return counterId;
    }

    public ArrayList<Rental> getLentBooks() {
        return lentBooks;
    }

    public void setLentBooks(ArrayList<Rental> lentBooks) {
        this.lentBooks = lentBooks;
    }

    public static void setCounterId(int counterId) {
        RentalRepository.counterId = counterId;
    }

    public int getAmountOfRentals() {
        return amountOfRentals;
    }

    public void setAmountOfRentals(int amountOfRentals) {
        this.amountOfRentals = amountOfRentals;
    }


}
