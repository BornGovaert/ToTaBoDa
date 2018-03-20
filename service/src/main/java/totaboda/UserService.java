package totaboda;

import be.totaboda.Repositories.UserRepository;
import be.totaboda.Users.Employee;
import be.totaboda.Users.LoggedInUser;
import be.totaboda.Users.Member;
import totaboda.Exceptions.UnknownResourceException;

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

    public LoggedInUser getUser(int userID) throws UnknownResourceException {
        return null;
    }

    public void removeUser(int userID) throws UnknownResourceException {
    }

    public LoggedInUser addUser(LoggedInUser user) {
        return null;
    }

    public List<LoggedInUser> getAllUsers() {
        return null;
    }

    public List<Member> getAllMembers() {
        return null;
    }

    public List<Employee> getAllEmployees() {
        return null;
    }

    public LoggedInUser updateUser(int userID, Member user) throws UnknownResourceException {
        return null;
    }

}
