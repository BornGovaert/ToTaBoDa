package be.totaboda.Repositories;

import be.totaboda.Users.LoggedInUser;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private UserData mock;
    private UserRepository testRepository;
    private LoggedInUser user1;
    private LoggedInUser user2;

    @BeforeEach
    public void setUp() {

        mock = Mockito.mock(UserData.class);
        user1 = LoggedInUser.UserBuilder.buildUser()
                .withFirstName("T")
                .withLastName("L")
                .withEMail("t@t.be")
                .withStreetNumber("5")
                .withStreetName("s")
                .withPostalCode("1")
                .withCity("c")
                .withInss("4")
                .build();

        user2 = LoggedInUser.UserBuilder.buildUser()
                .withFirstName("L")
                .withLastName("T")
                .withEMail("t@l.be")
                .withStreetNumber("4")
                .withStreetName("x")
                .withPostalCode("1")
                .withCity("c")
                .withInss("3")
                .build();
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
}
