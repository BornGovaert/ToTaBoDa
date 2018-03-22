package be.totaboda.domain.rental;

import java.time.LocalDate;

public class Rental {

    private int id;
    private String memberInss;
    private String bookIsbn;
    private LocalDate startDate;
    private LocalDate returnDate;

    public Rental(String memberInss, String bookIsbn) {
        this.memberInss = memberInss;
        this.bookIsbn = bookIsbn;
        this.startDate = LocalDate.now();
        this.returnDate = startDate.plusWeeks(3) ;
    }

    public int getId() {
        return id;
    }

    public String getMemberInss() {
        return memberInss;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
