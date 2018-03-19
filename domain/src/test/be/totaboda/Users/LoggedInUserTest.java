package be.totaboda.Users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LoggedInUserTest {

    @Test
    public void createALoggedInUser_HappyPath(){
        LoggedInUser testUser = LoggedInUser.UserBuilder.BuildAPerson().withFirstName("T")
                .withLastName("L")
                .withStreetName("s")
                .withStreetNumber("5")
                .withPostalCode("1234")
                .withCity("City")
                .withEMail("a@a.com")
                .withInss("1234")
                .build();

        assertThat(testUser.getFirstName()).isEqualTo("T");
        assertThat(testUser.getLastName()).isEqualTo("L");
        assertThat(testUser.getPostalCode()).isEqualTo("1234");
        assertThat(testUser.getStreetName()).isEqualTo("s");
        assertThat(testUser.getStreetNumber()).isEqualTo("5");
        assertThat(testUser.getCity()).isEqualTo("City");
        assertThat(testUser.geteMail()).isEqualTo("a@a.com");
        assertThat(testUser.getInss()).isEqualTo("1234");
    }
    @Test
    public void createALoggedInUser_whenEmailIsNotAValidEmailAdress_throwsException(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->LoggedInUser.UserBuilder.BuildAPerson().withFirstName("T")
                .withLastName("L")
                .withStreetName("s")
                .withStreetNumber("5")
                .withPostalCode("1234")
                .withCity("City")
                .withEMail("e")
                .withInss("1234")
                .build()).withMessage("Please provide a valid e-mail address.\nCorrect Format: \"xx@xx.xx\"");


    }
    @Test
    public void createALoggedInUser_whenloggedInUserIsNotCreatedWithAllTheArguments_throwsException(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->LoggedInUser.UserBuilder.BuildAPerson().withFirstName("T")
                .withLastName("L")
                .withStreetName("s")
                .withStreetNumber("5")
                .withPostalCode("1234")
                .withCity("City")
                .withInss("1234")
                .build()).withMessage("Please provide all the necessary arguments.");


    }
    



}