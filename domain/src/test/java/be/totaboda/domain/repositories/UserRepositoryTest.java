package be.totaboda.domain.repositories;

import be.totaboda.domain.users.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.List;

class UserRepositoryTest {
    private UserData mock;
    private UserRepository testRepository;
    private Member user1;
    private Member user2;
    private Employee employee1, employee2;

    @BeforeEach
    public void setUp() {

        mock = Mockito.mock(UserData.class);
        user1 = UserBuilder.buildUser()
                .withFirstName("T")
                .withLastName("L")
                .withEMail("t@t.be")
                .withStreetNumber("5")
                .withStreetName("s")
                .withPostalCode("1")
                .withCity("c")
                .withInss("4")
                .buildMember();

        user2 = UserBuilder.buildUser()
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

    @AfterEach

    public void cleaning() {
        testRepository = null;
    }

    @Test
    public void getAllUsers_HappyPath() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2));

        testRepository = new UserRepository(mock);

        List<LoggedInUser> expectedUsers = testRepository.getAllUsers();

        Assertions.assertThat(expectedUsers).isEqualTo(Arrays.asList(user1, user2));
    }

    @Test
    public void getUserWithId_happyPath() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2));

        testRepository = new UserRepository(mock);

        Assertions.assertThat(testRepository.getUserById(0)).isEqualTo(user1);

    }

    @Test
    public void getUserWithId_whenANonExistingIDIsProvided_throwsException() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2));

        testRepository = new UserRepository(mock);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testRepository.getUserById(3))
                .withMessage("No such user found.");
    }

    @Test
    public void removeUser_HappyPath() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2));

        testRepository = new UserRepository(mock);
        testRepository.removeUser(0);

        Assertions.assertThat(testRepository.getAllUsers().size()).isEqualTo(1);
    }

    @Test
    public void removeUser_whenANonExistingIDIsProvided_throwsException() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2));

        testRepository = new UserRepository(mock);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testRepository.removeUser(3))
                .withMessage("No such user found.");
    }

    @Test
    public void updateUser_HappyPath() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1));

        testRepository = new UserRepository(mock);
        testRepository.updateUser(0, user2);

        Assertions.assertThat(testRepository.getUserById(0)).isEqualTo(user2);
    }

    @Test
    public void updateUser_whenANonExistingIDIsProvided_throwsException() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2));

        testRepository = new UserRepository(mock);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testRepository.updateUser(3, user1))
                .withMessage("No such user found.");
    }

    @Test
    public void addUser_HappyPath() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1));

        testRepository = new UserRepository(mock);
        testRepository.addUser(user2);
        Assertions.assertThat(testRepository.getAllUsers()).containsExactly(user1, user2);
    }

    @Test
    public void addUser_givenUserWithInssThatAlreadyExists_throwsException() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1));

        testRepository = new UserRepository(mock);
        testRepository.addUser(user2);
        LoggedInUser user3 = UserBuilder.buildUser()
                .withFirstName("L")
                .withLastName("T")
                .withEMail("t@l.be")
                .withStreetNumber("4")
                .withStreetName("x")
                .withPostalCode("1")
                .withCity("c")
                .withInss(user2.getInss())
                .buildMember();

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testRepository.addUser(user2))
                .withMessage("E-mail or INSS already exist.");
    }

    @Test
    public void addUser_givenUserWithEmailThatAlreadyExists_throwsException() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1));

        testRepository = new UserRepository(mock);
        testRepository.addUser(user2);
        LoggedInUser user3 = UserBuilder.buildUser()
                .withFirstName("L")
                .withLastName("T")
                .withEMail(user2.geteMail())
                .withStreetNumber("4")
                .withStreetName("x")
                .withPostalCode("1")
                .withCity("c")
                .withInss("1324")
                .buildMember();

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testRepository.addUser(user2))
                .withMessage("E-mail or INSS already exist.");
    }

    @Test
    public void getAllMembers_returnsListOfMembers () {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2, employee1, employee2));
        testRepository = new UserRepository(mock);
        Assertions.assertThat(testRepository.getAllMembers()).containsExactly(user1, user2);
    }

    @Test
    public void getAllEmployees_returnsListOfEmployees () {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2, employee1, employee2));
        testRepository = new UserRepository(mock);
        Assertions.assertThat(testRepository.getAllEmployees()).containsExactly(employee1, employee2);
    }
}
