package be.totaboda.domain.rental;

import java.time.LocalDate;

public class Rental {

    private int id;
    private int memberId;
    private String bookIsbn;
    private LocalDate startDate;
    private LocalDate returnDate;


    public Rental(int memberId, String bookIsbn) {
        this.id = RentalRepository.getCounterId()+1;
        this.memberId = memberId;
        this.bookIsbn = bookIsbn;
        this.startDate = LocalDate.now();
        this.returnDate = startDate.plusWeeks(3) ;
    }

    public int getId() {
        return id;
    }

    public int getMemberId() {
        return memberId;
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

    public void setMemberInss(int memberId) {
        this.memberId = memberId;
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
