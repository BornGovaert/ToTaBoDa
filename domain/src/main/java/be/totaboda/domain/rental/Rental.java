package be.totaboda.domain.rental;

import java.time.LocalDate;

public class Rental {

    private int id;
    private String memberInss;
    private String bookIsbn;
    private LocalDate startDate;
    private LocalDate returnDate;


    public Rental(String memberInss, String bookIsbn) {
        this.id = RentalRepository.getCounterId();
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

    public void setId(int id) {
        this.id = id;
    }

    public void setMemberInss(String memberInss) {
        this.memberInss = memberInss;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
