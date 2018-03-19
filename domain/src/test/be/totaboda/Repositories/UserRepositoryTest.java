package be.totaboda.Repositories;

import be.totaboda.Users.LoggedInUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
   private UserRepository testRepository;
   private LoggedInUser user1;
   private LoggedInUser user2;
    @BeforeEach
    public void setUp(){
        testRepository = Mockito.mock(UserRepository.class);
        user1 = LoggedInUser.UserBuilder.BuildAPerson()
                .withFirstName("T")
                .withLastName("L")
                .withEMail("t@t.be")
                .withStreetNumber("5")
                .withStreetName("s")
                .withPostalCode("1")
                .withCity("c")
                .withInss("4")
                .build();
        user2 = LoggedInUser.UserBuilder.BuildAPerson()
                .withFirstName("L")
                .withLastName("T")
                .withEMail("t@l.be")
                .withStreetNumber("5")
                .withStreetName("s")
                .withPostalCode("1")
                .withCity("c")
                .withInss("4")
                .build();
    }

    @Test
    public void getAllUsers_HappyPath(){
        
        testRepository.addUser()
        Assertions.assertThat(testRepository.getAllUsers()).contains()
    }

    @Test
    public void getUserById_happyPath(){

        Assertions.assertThat(testRepository.getUserById(0)).isEqualTo()
    }

    @Test
    public void getUserById_whenIdThatDoesNotExistIsProvided_throwsAnException(){
        Assertions.assertThatThrownBy(IllegalArgumentException.class,
                (() -> testRepository.getUserById(5)))
    }

    @Test

}