package be.totaboda.service;

import be.totaboda.service.exceptions.UnknownResourceException;
import be.totaboda.service.exceptions.UnknownUserException;
import be.totaboda.domain.users.UserRepository;
import be.totaboda.domain.users.Employee;
import be.totaboda.domain.users.LoggedInUser;
import be.totaboda.domain.users.Member;

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

    public LoggedInUser updateUser(int userID, LoggedInUser user) throws UnknownResourceException {
        if(userRepository.assertThatUserExist(userID)){
            return userRepository.updateUser(userID,user);
        }
        throw new UnknownUserException(String.format("Update user failed. User %s $s with id: $s does not exist.", user.getFirstName(), user.getLastName(), user.getUserId()));
    }

}
