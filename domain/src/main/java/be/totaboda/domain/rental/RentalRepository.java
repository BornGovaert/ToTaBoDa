package be.totaboda.domain.rental;

import java.util.ArrayList;
import java.util.Random;

public class RentalRepository {

    private ArrayList<Rental> lentBooks;
    private static int counterId;
    private int amountOfRentals;

    public RentalRepository() {
        this.lentBooks = new ArrayList<>();
    }

    public RentalRepository(ArrayList<Rental> lentBooks) {
        this.lentBooks = lentBooks;
    }

    public void createRental(int memberId, String bookIsbn) {
        counterId++;
        Rental rentalObject = new Rental(memberId, bookIsbn);
        for (Rental newBook : lentBooks) {
            if (newBook.getMemberId() == memberId) {
                amountOfRentals++;
            } else if (newBook.getBookIsbn().equals(bookIsbn)) {
                throw new IllegalArgumentException("This book is already rented out");    //NEEDS CUSTOM EXCEPTIONS
            } else if (amountOfRentals > 2) {
                throw new IllegalArgumentException("You can only rent 9 bookS.");
            }
        }
        lentBooks.add(rentalObject);
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
