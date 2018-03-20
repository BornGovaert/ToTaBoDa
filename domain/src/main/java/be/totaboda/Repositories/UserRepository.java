package be.totaboda.Repositories;

import be.totaboda.Users.Employee;
import be.totaboda.Users.LoggedInUser;
import be.totaboda.Users.Member;
import be.totaboda.Users.Role;

import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Named
public class UserRepository {
    Map<Integer, LoggedInUser> users;
    private int idCounter = 0;

    public UserRepository(UserData userData) {
        users = new HashMap<>();
        userData.getDefaultUsers()
                .forEach(user -> addUser(user));
    }

    public LoggedInUser getUserById(int userId) {
        if (!users.keySet().contains(userId)) {
            throw new IllegalArgumentException("No such user found.");
        }
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
        if (!users.keySet().contains(userId)) {
            throw new IllegalArgumentException("No such user found.");
        } else {
            users.remove(userId);
        }
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

    public List<Member> getAllMembers() {
        return users
                .values()
                .stream()
                .filter(x -> x.getRole().equals(Role.ROLE_MEMBER))
                .map(x -> (Member) x)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        return users
                .values()
                .stream()
                .filter(x -> !x.getRole().equals(Role.ROLE_MEMBER))
                .map(x -> (Employee) x)
                .collect(Collectors.toList());
    }
}
