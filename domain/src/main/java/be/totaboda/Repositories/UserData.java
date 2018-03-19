package be.totaboda.Repositories;

import be.totaboda.Users.LoggedInUser;

import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
class UserData {

    public List<LoggedInUser> getDefaultUsers() {
        return Arrays.asList(LoggedInUser.UserBuilder.buildUser()
                        .withFirstName("David")
                        .withLastName("Van den Bergh")
                        .withEMail("david@hotmail.com")
                        .withInss("820101 383 03")
                        .withStreetName("steenweg")
                        .withStreetNumber("53")
                        .withCity("Welle")
                        .withPostalCode("9473")
                        .build(),
                LoggedInUser.UserBuilder.buildUser()
                        .withFirstName("Thomas")
                        .withLastName("Laurent")
                        .withEMail("TomTom@hotmail.com")
                        .withInss("880101 199 53")
                        .withStreetName("Rue de Bruxelles")
                        .withStreetNumber("1001")
                        .withCity("NAMUR")
                        .withPostalCode("5000")
                        .build(),
                LoggedInUser.UserBuilder.buildUser()
                        .withFirstName("Bruce")
                        .withLastName("Wayne")
                        .withEMail("IMNOTREALLYBATMAN@hotmail.com")
                        .withInss("791101 199 53")
                        .withStreetName("Batcave")
                        .withStreetNumber("1")
                        .withCity("GOTHAM")
                        .withPostalCode("79990")
                        .build());
    }
}
