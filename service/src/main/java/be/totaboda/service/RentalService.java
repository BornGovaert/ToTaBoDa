package be.totaboda.service;


import be.totaboda.domain.book.Book;
import be.totaboda.domain.book.BookRepository;
import be.totaboda.domain.rental.RentalRepository;
import be.totaboda.domain.users.Member;
import be.totaboda.domain.users.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
public class RentalService {

    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());
    private RentalRepository rentalRepository;
    private static UserRepository userRepository;
    private BookRepository bookRepository;

    @Inject
    public RentalService (UserRepository userRepository) {
        RentalService.userRepository = userRepository;
    }

    @Inject
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Inject
    public RentalService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void createRental(String memberInss, String bookIsbn) {
        for (Member member: userRepository.getAllMembers()) {
            if (member.getInss().equals(memberInss)) {
                for (Book book: bookRepository.getBooks())
                rentalRepository.createRental(memberInss, bookIsbn);
            } else {
                throw new IllegalArgumentException("Please provide a valid Inss");
            }
        }

    }


}
