package be.totaboda.domain.rental;

import java.util.ArrayList;
import java.util.Random;

public class RentalRepository {

    private ArrayList<Rental> lentBooks;
    private static int counterId;
    private int amountOfRentals;


    public RentalRepository(ArrayList<Rental> lentBooks) {
        this.lentBooks = lentBooks;
    }

    public void createRental(String memberInss, String bookIsbn) {
        counterId++;
        Rental rentalObject = new Rental(memberInss, bookIsbn);
        for (Rental newBook : lentBooks) {
            if (newBook.getMemberInss().equals(memberInss)) {
                amountOfRentals++;
            } else if (newBook.getBookIsbn().equals(bookIsbn)) {
                throw new IllegalArgumentException("This book is already rented out");    //NEEDS CUSTOM EXCEPTIONS
            } else if (amountOfRentals > 9) {
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
