package totaboda;

import be.totaboda.Repositories.UserData;
import be.totaboda.Repositories.UserRepository;
import be.totaboda.Users.LoggedInUser;
import be.totaboda.Users.Member;
import be.totaboda.Users.Role;
import be.totaboda.Users.UserBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import totaboda.Exceptions.UnknownResourceException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository mockRepository;
    private LoggedInUser member1;
    private LoggedInUser employee1;

//    @BeforeEach
//    public void setUp(){
//        mockRepository = Mockito.mock(UserRepository.class);
//        userService = new UserService(mockRepository);
//        member1= UserBuilder.buildUser()
//                .withFirstName("L")
//                .withLastName("T")
//                .withEMail("t@l.be")
//                .withStreetNumber("4")
//                .withStreetName("x")
//                .withPostalCode("1")
//                .withCity("c")
//                .withInss("3")
//                .buildMember();
//
//        employee1=UserBuilder.buildUser()
//                .withFirstName("John")
//                .withLastName("Constantine")
//                .withRole(Role.ROLE_ADMIN)
//                .withEMail("john.constantine@hell.com")
//                .buildEmployee();
//    }
//
//    @Test
//    public void getUser_happyPath(){
//        Mockito.when(mockRepository.getUserById(0)).thenReturn(member1);
//        Assertions.assertThat(userService.getUser(0)).isEqualTo(member1);
//    }
//
//    @Test
//    void getUser_whenANonExistingIdIsProvided_throwsexception(){
//        Assertions.assertThatExceptionOfType(UnknownResourceException.class)
//                .isThrownBy(()->userService.getUser(5));
//    }
//
//    @Test
//    public void removeUser_happyPath(){
//        UserService userService = new UserService(new UserRepository(new UserData()));
//        int expectedSize = userService.getAllUsers().size()-1;
//        LoggedInUser removedUser = userService.getUser(0);
//        userService.removeUser(0);
//        Assertions.assertThat(userService.getAllUsers().size()).isEqualTo(expectedSize);
//        Assertions.assertThat(!userService.getAllUsers().contains(removedUser));
//    }
//
//    @Test
//    void removeUser_whenANonExistingIdIsProvided_throwsexception() {
//        Assertions.assertThatExceptionOfType(UnknownResourceException.class)
//                .isThrownBy(() -> userService.getUser(5));
//    }


}