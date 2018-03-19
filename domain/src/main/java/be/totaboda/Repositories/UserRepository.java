package be.totaboda.Repositories;

import be.totaboda.Users.LoggedInUser;

import java.util.List;
import java.util.Map;

public class UserRepository {
    Map<Integer, LoggedInUser> userRepository;
    int idcounter =0;

    public UserRepository() {
    }

    public LoggedInUser getUserById(int userId) {
        return null;
    }
    public List<LoggedInUser> getAllUsers () {
        return null;
    }
    public LoggedInUser addUser(LoggedInUser user) {
        return null;
    }
    public void removeUser(int userId) {

    }
}
