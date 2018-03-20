package totaboda;

import be.totaboda.Repositories.UserData;
import be.totaboda.Repositories.UserRepository;
import be.totaboda.Users.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import totaboda.Exceptions.UnknownResourceException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository mockRepository;
    private Member member1, member2;
    private Employee employee1,employee2;

    @BeforeEach
    public void setUp() {
        mockRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(mockRepository);
        member1 = UserBuilder.buildUser()
                .withFirstName("L")
                .withLastName("T")
                .withEMail("t@l.be")
                .withStreetNumber("4")
                .withStreetName("x")
                .withPostalCode("1")
                .withCity("c")
                .withInss("3")
                .buildMember();
        member2 = UserBuilder.buildUser()
                .withFirstName("L")
                .withLastName("T")
                .withEMail("t@l.be")
                .withStreetNumber("4")
                .withStreetName("x")
                .withPostalCode("1")
                .withCity("c")
                .withInss("3")
                .buildMember();

        employee1 = UserBuilder.buildUser()
                .withFirstName("John")
                .withLastName("Constantine")
                .withRole(Role.ROLE_ADMIN)
                .withEMail("john.constantine@hell.com")
                .buildEmployee();

        employee2 = UserBuilder.buildUser()
                .withFirstName("Clark")
                .withLastName("Kent")
                .withRole(Role.ROLE_LIBRARIAN)
                .withEMail("Clark.kent@do.it")
                .buildEmployee();
    }

    @Test
    public void getUser_happyPath() {
        Mockito.when(mockRepository.getUserById(0)).thenReturn(member1);
        Mockito.when(mockRepository.assertThatUserExist(0)).thenReturn(true);
        Assertions.assertThat(userService.getUser(0)).isEqualTo(member1);
    }

    @Test
    void getUser_whenANonExistingIdIsProvided_throwsexception() {
        Assertions.assertThatExceptionOfType(UnknownResourceException.class)
                .isThrownBy(() -> userService.getUser(5));
    }

    @Test
    public void removeUser_happyPath() {
        UserService userService = new UserService(new UserRepository(new UserData()));
        int expectedSize = userService.getAllUsers().size() - 1;
        LoggedInUser removedUser = userService.getUser(0);
        userService.removeUser(0);
        Assertions.assertThat(userService.getAllUsers().size()).isEqualTo(expectedSize);
        Assertions.assertThat(!userService.getAllUsers().contains(removedUser));
    }

    @Test
    void removeUser_whenANonExistingIdIsProvided_throwsexception() {
        Assertions.assertThatExceptionOfType(UnknownResourceException.class)
                .isThrownBy(() -> userService.getUser(5));
    }

    @Test
    void addUser_happyPath() {
        Mockito.when(mockRepository.addUser(member1)).thenReturn(member1);
        Assertions.assertThat(userService.addUser(member1)).isEqualTo(member1);
    }

    @Test
    void getAllMembers_happyPath() {
        Mockito.when(mockRepository.getAllMembers()).thenReturn(Arrays.asList(member1, member2));
        Assertions.assertThat(userService.getAllMembers()).containsExactly(member1, member2);
    }

    @Test
    void getAllEmployees_happyPath() {
        Mockito.when(mockRepository.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));
        Assertions.assertThat(userService.getAllEmployees()).containsExactly(employee1, employee2);
    }

    @Test
    void getAllUsers_happyPath() {
        Mockito.when(mockRepository.getAllUsers()).thenReturn(Arrays.asList(employee1, employee2));
        Assertions.assertThat(userService.getAllUsers()).containsExactly(employee1, employee2);
    }

    @Test
    void updateUser_happyPath() {
        Mockito.when(mockRepository.updateUser(0, employee1)).thenReturn(employee1);
        Mockito.when(mockRepository.assertThatUserExist(0)).thenReturn(true);
        Assertions.assertThat(userService.updateUser(0, employee1)).isEqualTo(employee1);
    }
    @Test
    void updateUser_userNotInRepository() {
        Mockito.when(mockRepository.assertThatUserExist(0)).thenReturn(false);
        Assertions.assertThatExceptionOfType(UnknownResourceException.class)
                .isThrownBy(() ->userService.updateUser(0, employee1));
    }

}