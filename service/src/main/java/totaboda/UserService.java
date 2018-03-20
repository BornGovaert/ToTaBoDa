package totaboda;

import be.totaboda.Repositories.UserRepository;
import be.totaboda.Users.LoggedInUser;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserService {
    private static UserRepository userRepository;
    
    @Inject
    public UserService (UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public LoggedInUser getUser(int userID) {
        return null;
    }

    public void removeUser(int userID) {
    }

    public LoggedInUser addUser(LoggedInUser user) {
        return null;
    }

    public List<LoggedInUser> getAllUsers() {
        return null;
    }

    public LoggedInUser updateUser(int userID, LoggedInUser user) {
        return null;
    }

}
