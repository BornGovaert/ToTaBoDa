package be.totaboda.Repositories;

import be.totaboda.Users.LoggedInUser;

import javax.inject.Named;
import java.util.*;

@Named
public class UserRepository {
    Map<Integer, LoggedInUser> users;
    private static int idCounter = 0;

    public UserRepository() {
        users = new HashMap<>();
        addDefaultUsers();
    }

    public LoggedInUser getUserById(int userId) {
        return users.get(userId);
    }

    public List<LoggedInUser> getAllUsers() {
        return Collections.unmodifiableList(new ArrayList<LoggedInUser>(users.values()));
    }

    public LoggedInUser addUser(LoggedInUser user) {
        user.setUserId(idCounter);
        users.put(idCounter, user);
        idCounter++;
        return user;
    }

    public void removeUser(int userId) {
        users.remove(userId);
    }

    public LoggedInUser updateUser(int userID, LoggedInUser user) {
        if (users.containsKey(userID)) {
            user.setUserId(userID);
            users.put(userID, user);
        } else {
            throw new IllegalArgumentException("No such user found.");
        }
        return user;
    }

    private void addDefaultUsers() {
        addUser(LoggedInUser.UserBuilder.buildUser()
                .withFirstName("David")
                .withLastName("Van den Bergh")
                .withEMail("david@hotmail.com")
                .withInss("820101 383 03")
                .withStreetName("steenweg")
                .withStreetNumber("53")
                .withCity("Welle")
                .withPostalCode("9473")
                .build()
        );
        addUser(LoggedInUser.UserBuilder.buildUser()
                .withFirstName("Thomas")
                .withLastName("Laurent")
                .withEMail("TomTom@hotmail.com")
                .withInss("880101 199 53")
                .withStreetName("Rue de Bruxelles")
                .withStreetNumber("1001")
                .withCity("NAMUR")
                .withPostalCode("5000")
                .build()
        );
        addUser(LoggedInUser.UserBuilder.buildUser()
                .withFirstName("Bruce")
                .withLastName("Wayne")
                .withEMail("IMNOTREALLYBATMAN@hotmail.com")
                .withInss("791101 199 53")
                .withStreetName("Batcave")
                .withStreetNumber("1")
                .withCity("GOTHAM")
                .withPostalCode("79990")
                .build()
        );
    }
}
