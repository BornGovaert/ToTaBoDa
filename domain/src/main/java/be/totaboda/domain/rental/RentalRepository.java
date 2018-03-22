package be.totaboda.domain.rental;

import java.util.ArrayList;
import java.util.Random;

public class RentalRepository {

    private ArrayList<Rental> lentBooks;




    public RentalRepository(ArrayList<Rental> lentBooks) {
        this.lentBooks = lentBooks;
    }

    public void createRental(String memberInss, String bookIsbn){

        Rental temporaryRental = new Rental(memberInss, bookIsbn);
        for (Rental newBook: lentBooks) {
           
        }

    }
}
