package be.totaboda.service;

//
//import be.totaboda.domain.book.Book;
//import be.totaboda.domain.book.BookRepository;
//import be.totaboda.domain.rental.RentalRepository;
//import be.totaboda.domain.users.Member;
//import be.totaboda.domain.users.UserRepository;
//
//import javax.inject.Inject;
//import javax.inject.Named;
//import java.util.logging.Logger;
//
//@Named
//public class RentalService {
//
//    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());
//    private RentalRepository rentalRepository;
//    private UserRepository userRepository;
//    private BookRepository bookRepository;
//
//    @Inject
//    public RentalService(UserRepository userRepository, RentalRepository rentalRepository, BookRepository bookRepository) {
//        this.userRepository = userRepository;
//        this.rentalRepository = rentalRepository;
//        this.bookRepository = bookRepository;
//    }
//
////    public void createRental(int memberId, String bookIsbn) {
////        if (memberInss !=null) {
////            for (Member member : userRepository.getAllMembers()) {
////                if (member.getInss().equals(memberInss)) {
////                    for (Book book : bookRepository.getBooks()) {
////                        if (book.getIsbn().equals(bookIsbn)) {
////                            rentalRepository.createRental(memberInss, bookIsbn);
////                        }
////                    }
////                }
////            }
////        }
////    }
//
//}
