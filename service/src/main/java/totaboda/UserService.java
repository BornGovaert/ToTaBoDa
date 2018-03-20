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
        if(userRepository.assertThatUserExist(userID)){
         return userRepository.getUserById(userID);
        }
        throw new UnknownResourceException("User","User ID: "+ userID);
    }

    public void removeUser(int userID) throws UnknownResourceException {
        if(userRepository.assertThatUserExist(userID)){
            userRepository.removeUser(userID);
        }
        else throw new UnknownResourceException("User","User ID: "+ userID);
    }

    public LoggedInUser addUser(LoggedInUser user) {
        return userRepository.addUser(user);
    }

    public List<LoggedInUser> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public List<Member> getAllMembers() {
        return userRepository.getAllMembers();
    }

    public List<Employee> getAllEmployees() {
        return userRepository.getAllEmployees();
    }

    public LoggedInUser updateUser(int userID, Member user) throws UnknownResourceException {
        if(userRepository.assertThatUserExist(userID)){
            return userRepository.updateUser(userID,user);
        }
        throw new UnknownResourceException("User","User ID: "+ userID);
    }

}
