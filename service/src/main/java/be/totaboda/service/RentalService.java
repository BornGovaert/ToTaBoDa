package be.totaboda.service;


import be.totaboda.domain.book.Book;
import be.totaboda.domain.book.BookRepository;
import be.totaboda.domain.rental.Rental;
import be.totaboda.domain.rental.RentalRepository;
import be.totaboda.domain.users.Member;
import be.totaboda.domain.users.UserRepository;
import be.totaboda.service.exceptions.LibraryException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
public class RentalService {

    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());

    private RentalRepository rentalRepository;
    private UserRepository userRepository;
    private BookRepository bookRepository;

    @Inject
    public RentalService(UserRepository userRepository, RentalRepository rentalRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.rentalRepository = rentalRepository;
        this.bookRepository = bookRepository;
    }

    public Rental createRental(int memberId, String bookIsbn) {
        boolean noRentalCreatedYet = true;
        if (memberId != 0 && bookIsbn != null && noRentalCreatedYet) {
            for (Member member : userRepository.getAllMembers()) {
                if (member.getUserId() == memberId) {
                    for (Book book : bookRepository.getBooks()) {
                        if (book.getIsbn().equals(bookIsbn)) {
                            rentalRepository.createRental(memberId, bookIsbn);
                            noRentalCreatedYet = false;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
//        if (noRentalCreatedYet = false) {
//            throw new LibraryException("Please provide valid id or isbn");
  //     }
       else {
            throw new LibraryException("Please provide valid id or isbn");
       }
        return rentalRepository.createRental(memberId, bookIsbn);
    }


}
