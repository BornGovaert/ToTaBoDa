package be.totaboda.Repositories;

import be.totaboda.Users.LoggedInUser;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
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
        testRepository = new UserRepository(mock);
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

    @Test
    public void getAllUsers_HappyPath() {
        Mockito.when(mock.getDefaultUsers()).thenReturn(Arrays.asList(user1, user2));

        testRepository = new UserRepository(mock);

        List<LoggedInUser> expectedUsers = testRepository.getAllUsers();

        Assertions.assertThat(expectedUsers).isEqualTo(Arrays.asList(user1,user2));
    }
}
