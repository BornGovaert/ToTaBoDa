package be.totaboda.service;

import be.totaboda.domain.author.AuthorRepository;
import be.totaboda.domain.book.Book;
import be.totaboda.domain.book.BookRepository;
import be.totaboda.domain.rental.RentalRepository;
import be.totaboda.domain.users.Member;
import be.totaboda.domain.users.UserBuilder;
import be.totaboda.domain.users.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RentalServiceTest {

    RentalService rentalService;
    RentalRepository mockRentalRepo;
    UserRepository mockUserRepo;
    BookRepository mockBookRepo;

    private List<Book> testList;
    private Book book1;
    private BookService bookService;
    private AuthorRepository authorRepository = new AuthorRepository();

    private List<Member> testList2;
    private Member member;
    private UserService userService;


    @BeforeEach
    void setUp() {
        mockBookRepo = mock(BookRepository.class);
        mockRentalRepo = mock(RentalRepository.class);
        mockUserRepo = mock(UserRepository.class);

        rentalService = new RentalService(mockUserRepo, mockRentalRepo, mockBookRepo);

        //Changes
        bookService = new BookService(mockBookRepo);
        testList = new ArrayList<>();
        book1 = new Book("111", "Azkaban", authorRepository.getAuthorDatabase().get("1"));
        testList.add(book1);

        userService = new UserService(mockUserRepo);
        testList2 = new ArrayList<>();
        member = UserBuilder.buildUser()
                .withFirstName("L")
                .withLastName("T")
                .withEMail("t@l.be")
                .withStreetNumber("4")
                .withStreetName("x")
                .withPostalCode("1")
                .withCity("c")
                .withInss("3")
                .buildMember();
        testList2.add(member);
    }

    @Test
    void createRental_happyPath() {
        //GIVEN
        Mockito.when(mockBookRepo.getBooks()).thenReturn(testList);
        Mockito.when(mockUserRepo.getAllMembers()).thenReturn(testList2);
        //WHEN
        rentalService.createRental(1, "111");
        //THEN
        verify(mockRentalRepo, times(1)).createRental(1, "111");
    }

    @Test
    void createRental_givenIncorrectBookIsbn_throwException() {

    }

    @Test
    void createRental_givenIncorrectMemberId_throwException() {

    }


}